package neetcode.amazon;

public class MedianOfSortedArray {

    static int findMedian(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int medianIndex) {

        // medianIndex in array 'a'
        int aMedianIdx = aStart + medianIndex;
        // base condition # 1
        if (aEnd >= aMedianIdx && a[aMedianIdx] < b[bStart]) {
            return a[aMedianIdx];
        }

        // medianIndex in array 'b'
        int bMedianIdx = bStart + medianIndex;
        // base condition # 2
        if (bEnd >= bMedianIdx && b[bMedianIdx] < a[aStart]) {
            return b[bMedianIdx];
        }

        int aLength = (aEnd - aStart) + 1;
        int bLength = (bEnd - bStart) + 1;

        // base condition # 3
        if ((aLength + bLength - 1) == medianIndex) {
            // median is last element of the merged array
            return Math.max(a[aLength - 1], b[bLength - 1]);
        }

        int midAIdx = aLength / 2;
        int midBIdx = bLength / 2;
        if (a[midAIdx] < b[bStart]) {
            // ignore first half of array 'a' up to midAIdx
            return findMedian(a, midAIdx + 1, aEnd, b, bStart, bEnd, medianIndex - midAIdx - 1);
        }
        if (b[midBIdx] < a[aStart]) {
            // ignore first half of array 'b' up to midBIdx
            return findMedian(a, aStart, aEnd, b, midBIdx + 1, bEnd, medianIndex- midBIdx - 1);
        }

        // ignore last half of both array 'a' and 'b'
        return findMedian(a, aStart, midAIdx, b, bStart, midBIdx, medianIndex);
    }

    public static void main(String[] args) {
         int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 16, 17, 18, 19, 20, 21, 22, 23};
         int[] b = {11, 12, 13, 40, 19};
        int medianIndex = (a.length + b.length) / 2;
        int median = findMedian(a, 0, a.length - 1, b, 0, b.length - 1, medianIndex);
        System.out.println("Should be 12 : " + median);

        int[] c = {1, 13, 16, 25};
        int[] d = {2, 5, 17};
        medianIndex = (c.length + d.length) / 2;
        median = findMedian(c, 0, c.length - 1, d, 0, d.length - 1, medianIndex);
        System.out.println("Should be 13 : " + median);

        int[] d1 = {14, 15, 17};
        medianIndex = (c.length + d1.length) / 2;
        median = findMedian(c, 0, c.length - 1, d1, 0, d1.length - 1, medianIndex);
        System.out.println("Should be 15 : " + median);

        int[] e = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int[] f = {111, 112, 113, 140, 219};
        medianIndex = (e.length + f.length) / 2;
        median = findMedian(e, 0, e.length - 1, f, 0, f.length - 1, medianIndex);
        System.out.println("Should be 12 : " + median);
    }

}
