import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[3][N];
        dp = new int[3][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int rCost = Integer.parseInt(st.nextToken());
            int gCost = Integer.parseInt(st.nextToken());
            int bCost = Integer.parseInt(st.nextToken());

//            arr[0][i] = rCost;
//            arr[1][i] = gCost;
//            arr[2][i] = bCost;

            dp[0][i] = rCost;
            dp[1][i] = gCost;
            dp[2][i] = bCost;
        }

//        dp[0][0] = arr[0][0];   // 첫 번째 집 rCost
//        dp[1][0] = arr[1][0];   // 첫 번째 집 gCost
//        dp[2][0] = arr[2][0];   // 첫 번째 집 bCost

        for (int i = 1; i < N; i++) {

            dp[0][i] = dp[0][i] + Math.min(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = dp[1][i] + Math.min(dp[0][i - 1], dp[2][i - 1]);
            dp[2][i] = dp[2][i] + Math.min(dp[0][i - 1], dp[1][i - 1]);

        }

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int min = Math.min(dp[0][N-1], (Math.min(dp[1][N-1], dp[2][N-1])));
        System.out.println(min);
    }
}