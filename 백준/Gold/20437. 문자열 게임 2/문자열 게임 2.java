import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
           String s = br.readLine();
            int K = Integer.parseInt(br.readLine());
           int len = s.length();
           int[] alpha = new int[26];
            for (int i = 0; i < len; i++) {
                alpha[s.charAt(i)-'a']++;
            }
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if(alpha[c-'a'] < K) continue;
                int cnt = 0;
                for (int j = i; j < len; j++) {
                    if(c == s.charAt(j)) cnt++;
                    if (cnt == K) {
                        max = Math.max(max,j-i+1);
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }
            if (max == -1 || min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            }
            else{
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}