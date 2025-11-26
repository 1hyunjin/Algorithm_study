import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length()+1];
        int[] sumArr = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            arr[i+1] = s.charAt(i) - '0';
        }
        for (int i = 1; i <= s.length(); i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }
        int maxLen =0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j+=2) {
                int diff = sumArr[j] - sumArr[i-1];
                int midIdx = (i+j)/2;
                int midVal = sumArr[midIdx] - sumArr[i-1];
                if (midVal*2 == diff) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        System.out.println(maxLen);
    }
}