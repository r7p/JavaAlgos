/**
 * Created by rpatel on 5/26/17.
 */
public class NearestToK {

    int findNearest(int[] a, int x) {
        int low = 0, high = a.length -1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] == x) {
                return x;
            }
            if (high == low + 1) {
                //only two elements left, return closest between these two
                return closestBetween(a[low], a[high], x);
            }

            //walk left one step
            if (x >= a[mid - 1] && x <= a[mid]) {
                //return closest between these two
                return closestBetween(a[mid-1], a[mid], x);
            }

            //walk right one step
            if (x >= a[mid] && x <= a[mid + 1]) {
                //return closest between these two
                return closestBetween(a[mid], a[mid+1], x);
            }

            //x is neither between left & mid AND mid & right element.  Find the direction for binary search
            int diff = x - a[mid];
            if (diff < a[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return a[high];
    }

    int closestBetween(int a, int b, int x) {
        int diff1 = Math.abs(x - a);
        int diff2 = Math.abs(x - b);
        if (diff1 <= diff2) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        NearestToK x = new NearestToK();

        int[] a = new int[] {-5, -2, -1, 0, 50, 60, 70, 80};

        System.out.println("Nearest to -3 is " + x.findNearest(a, -3));
        System.out.println("Nearest to 54 is " + x.findNearest(a, 54));
        System.out.println("Nearest to 55 is " + x.findNearest(a, 55));
        System.out.println("Nearest to 56 is " + x.findNearest(a, 56));
        System.out.println("Nearest to -4 is " + x.findNearest(a, -4));

        int[] b = new int[] {9, 10, 10, 10, 10, 10, 10, 10};
        System.out.println("Nearest to 10 is " + x.findNearest(b, 10));

        int[] c = new int[] {1, 2, 100, 100, 102};
        System.out.println("Nearest to 3 is " + x.findNearest(c, 3));

    }
}
