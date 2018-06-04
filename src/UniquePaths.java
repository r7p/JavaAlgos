/**
 * Given M x N matrix, find unique path to a coordinate by moving either right or down.
 * Using Math: First subtract 1 from M & N, i.e. m = M - 1; n = N - 1
 * Then use this formula (m+n)!/(m! * n!)
 *
 * Basically, to get to point at (M,N) you have to make M Horizontal moves and N vertical moves, total M+N moves.
 *
 * https://math.stackexchange.com/questions/636128/calculating-the-number-of-possible-paths-through-some-squares
 */
public class UniquePaths {
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
            a[0][2] = 0;
            a[1][0] = 0;

        System.out.println(count_dp(a));
    }

    static int count_dp(int a[][]){
        int rows = a.length;
        int cols = a[0].length;
        int[][] dp = new int[rows][cols];

        // if starting point OR end point is 0,
        // you can never reach destination
        if (a[0][0] == 0 || a[rows-1][cols-1] == 0) {
            return 0;
        }

        dp[0][0] = a[0][0];

        for(int i=1;i<rows;i++) {
            if(a[i][0]==1 && dp[i-1][0]==1) {
                dp[i][0] = 1;
            }
        }


        for(int i=1;i<cols;i++) {
            if(a[0][i]==1 && dp[0][i-1]==1) {
                dp[0][i] = 1;
            }
        }


        for(int i=1;i<rows;i++) {
            for(int j=1;j<cols;j++) {
                if(a[i][j]==1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }


        return dp[rows-1][cols-1];
    }
}
