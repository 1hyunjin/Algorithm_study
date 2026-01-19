import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if (alpha[n] == -1) {
                alpha[n] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}