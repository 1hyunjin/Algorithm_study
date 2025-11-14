import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int max = dp[s1.length()][s2.length()];
        System.out.println(max);
        char[] result = new char[max];
        int i = s1.length();
        int j = s2.length();
        int idx = 0;
        while (true) {
            if (idx == max) {
                break;
            }
            if (dp[i][j] == 0) {
                break;
            }
            if (dp[i][j] == dp[i - 1][j]) {
                i = i-1;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j = j-1;
            }
            else{
                result[idx] = s1.charAt(i-1);
                i = i-1;
                j = j-1;
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int s = result.length - 1; s >= 0; s--) {
            sb.append(result[s]);
        }
        System.out.println(sb.toString());
    }
}