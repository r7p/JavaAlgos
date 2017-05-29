/**
 * Created by Raj on 4/25/2016.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] list = {1, 3, 4, 6, 8, 12, 13};
        System.out.println(binarySearch(list, 0, list.length - 1, 12));
        System.out.println(binarySearchNonRecursive(list, 16));
    }

    public static int binarySearch(int[] list, int fromIndex, int toIndex, int search) {

        if (toIndex < fromIndex) {
            return -1;
        }

        int mid = (toIndex + fromIndex)/2;
        int midValue = list[mid];

        if (midValue == search) {
            return mid;
        } else if (midValue > search) {
            return binarySearch(list, fromIndex, mid -1, search);
        } else  {
            return binarySearch(list, mid + 1, toIndex, search);
        }

    }

    public static int binarySearchNonRecursive(int[] list, int search) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int midValue = list[mid];
            if (midValue == search) {
                return mid;
            } else if (midValue > search) {
                high = mid - 1;
            } else if (midValue < search) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
