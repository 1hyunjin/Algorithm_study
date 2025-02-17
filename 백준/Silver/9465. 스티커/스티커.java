import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n+1];

            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            print(n, arr);

            int[][] dp = new int[3][n+1];

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

//            print(n, dp);
//            int max = Math.max(dp[1][1], dp[1][2]);

            if (n >= 2) {
                dp[1][2] = dp[2][1] + arr[1][2];
                dp[2][2] = dp[1][1] + arr[2][2];

//                max = Math.max(dp[1][2], dp[2][2]);
//                print(n, dp);

                for (int i = 3; i <= n; i++) {

                    int diff = Math.max(dp[1][i - 2], dp[2][i - 2]);
//                    System.out.println("전에 줄 선택 안했을 때 max 값");
                    dp[1][i] =  diff + arr[1][i];
                    dp[2][i] =  diff + arr[2][i];
//                    System.out.println("dp[1][i] : " + dp[1][i]);
//                    System.out.println("dp[2][i] : " + dp[2][i]);
//                    System.out.println("-----------------------------");

                    dp[1][i] = Math.max(dp[1][i], dp[2][i-1] + arr[1][i]);
                    dp[2][i] = Math.max(dp[2][i], dp[1][i - 1] + arr[2][i]);

//                    max = Math.max(dp[1][i], dp[2][i]);

//                    print(n, dp);
                }
            }
//            System.out.println(Math.max(dp[1][n], dp[2][n]));
            int result = Math.max(dp[1][n], dp[2][n]);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void print(int n, int[][] dp) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
}