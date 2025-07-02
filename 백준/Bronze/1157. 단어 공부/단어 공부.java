import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char upper = Character.toUpperCase(c);
            alpha[upper-'A']++;
        }
        int max = 0;
        int maxCnt = 0;
        int result = 0;

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                if (max < alpha[i]) {
                    max = alpha[i];
                    result = i;
                    maxCnt = 1;
                } else if (max == alpha[i]) {
                    maxCnt++;
                }
            }
        }
        if (maxCnt > 1) {
            System.out.println('?');
        }
        else{
            System.out.println((char) (result+'A'));
        }
    }
}