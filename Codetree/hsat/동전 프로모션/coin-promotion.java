import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] cType = new char[n+1];
        int[] coin = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cType[i] = sc.next().charAt(0);
            coin[i] = sc.nextInt();
        }
        int INF = m+1;
        // Please write your code here.
        int[][] dp  = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0; // 동전 사용하지 않고 금액 0을 만드는 데 필요한 동전은 0개니까. 

        for(int i = 1; i <= n; i++){
            int cost = coin[i];
            char type = cType[i];

            for(int j = 0; j <= m; j++){
                if(j < cost){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    if(type == 'A'){
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-cost]+1);
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-cost]+1);
                    }
                }
            }
        }
        int answer = INF;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, dp[i][m]);
        }
        if(answer == INF){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
}