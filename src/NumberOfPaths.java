/**
 * Created by Raj on 4/21/2016.
 */
public class NumberOfPaths {
    private static int M, N;


    public static void main(String[] args) {
        M = 3; N = 3;
        int[][] a = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = 1;
            }
        }
        //M = 3; N = 3;
        a[1][1] = 0;
        int numberOfPaths = numberOfPaths(a, 0, 0);
        System.out.println(numberOfPaths);

        M = 7; N = 7;
        int[][] b = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                b[i][j] = 1;
            }
        }
        b[0][2] = 0;
        b[0][5] = 0;

        b[1][0] = 0;
        b[1][2] = 0;
        b[1][3] = 0;

        b[2][4] = 0;
        b[2][6] = 0;

        b[3][0] = 0;
        b[3][2] = 0;

        b[4][0] = 0;
        b[4][2] = 0;
        b[4][3] = 0;
        b[4][5] = 0;

        b[5][0] = 0;
        b[5][5] = 0;

        b[6][0] = 0;
        b[6][1] = 0;
        b[6][2] = 0;
        b[6][3] = 0;

        numberOfPaths = search(b, 0, 0);
        System.out.println(numberOfPaths);
    }

    static int numberOfPaths(int [][]a,int i,int j) {
        int iMax = a.length - 1;
        int jMax = a[0].length - 1;

        // if starting point OR end point is 0,
        // you can never reach destination
        if (a[0][0] == 0 || a[iMax][jMax] == 0) {
            return 0;
        }

        if (i > iMax || j > jMax || a[i][j] == 0) {
            return 0;
        }

        // if we reached destination increment the
        // path count by one and return
        int pathCount = 0;
        if (i == iMax && j == jMax) {
            return ++pathCount;
        }

        pathCount += numberOfPaths(a, i + 1, j);
        pathCount += numberOfPaths(a, i, j + 1);
        return pathCount;

//        // try to reach a[iMax][jMax] by moving right
//        // from current co-ordinates. If we reach,
//        // count will be incremented and bubbled up
//        // through the recursive calls.
//        if (i + 1 <= iMax && a[i + 1][j] == 1) {
//            count = numberOfPaths(a, i + 1, j);
//        }
//
//        // try to reach a[iMax][jMax] by moving down
//        // from current co-ordinates. If we reach,
//        // count will be incremented and bubbled up
//        // through the recursive calls.
//        if (j + 1 <= jMax && a[i][j + 1] == 1) {
//            count = numberOfPaths(a, i, j + 1);
//        }

        // return the count.
       // return count;
    }

//    static void depthFirst(int [][]a,int x,int y) {
//        if (a[x][y]==0 || x>M || y>N){
//            return;
//        }
//        if (x==M && y==N){
//            count++;
//            return;
//        }
//        depthFirst(a, x, y+1);
//        depthFirst(a, x+1, y);
//    }


    public static int search(int[][] a, int i, int j)
    {
        if(!exist(a, i,j) || a[i][j] == 1)
            return 0; // no path here.
        if(i == a.length - 1 && j == a[i].length - 1)
        {
            return 1; // 1 path here.
        }
        a[i][j] = 1; // mark that we have seen this spot here
        int paths = 0; // introduce a counter...
        paths += search(a, i+1,j); // add the additional paths as we find them
        paths += search(a, i-1,j);
        paths += search(a, i,j+1);
        paths += search(a, i,j-1);
        a[i][j] = 0;
        return paths; // return the number of paths available from this point.
    }

    public static boolean exist(int[][] a, int i, int j)
    {
        return i>=0 && j >=0 && i < a.length && j < a[i].length;
    }

}
