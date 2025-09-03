import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for (int i = 0; i < n - 1; i++) {
            String next = br.readLine();
            int cnt = 0;
            int[] alpha = new int[26];

            for (int j = 0; j < first.length(); j++) {
                int idx = first.charAt(j)-'A';
                alpha[idx]+=1;
            }
            for (int j = 0; j < next.length(); j++) {
                int idx = next.charAt(j)-'A';
                if (alpha[idx] > 0) {
                    cnt++;
                    alpha[idx]--;
                }
            }

            if (first.length() == next.length() && (cnt == first.length() || cnt == first.length() - 1)) {
                result++;
            } else if (first.length() == next.length() + 1 && cnt == next.length()) {
                result++;
            } else if (first.length() == next.length() - 1 && cnt == next.length() - 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}