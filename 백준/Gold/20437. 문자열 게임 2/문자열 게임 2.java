import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1").append("\n");
                continue;
            }
            int[] alpha = new int[26];
            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i)-'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < s.length(); i++) {
                if(alpha[s.charAt(i)-'a'] < K) continue;

                int cnt = 1;

                for (int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(i)==s.charAt(j)) cnt++;
                    if (cnt == K) {
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}