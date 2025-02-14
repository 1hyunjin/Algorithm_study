import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] info = new int[N+1][2];

        for (int i = N; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for (int i = 1; i < dp.length; i++) {
            if (info[i][0] > i) {
                // 해당 일자에 주어진 상담 업무를 할 수 없는 경우에는 제외하고
                // 그 전의 근무 가능한 일자의 최대 비용값을 가져옴
                dp[i] = dp[i-1];
            }
            else {
                // 해당 일자에 주어진 상담 없무를 할 수 있는 경우
                // 1. 상담 업무를 하지 않았을 때의 경우와
                // 2. 상담해서 번 비용 + dp[근무가능일수 - 해당상담일자]
                dp[i] = Math.max(dp[i - 1], info[i][1] + dp[i - info[i][0]]);
            }
        }
        System.out.println(dp[N]);
    }
}