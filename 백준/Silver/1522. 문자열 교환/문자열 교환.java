import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int aCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                aCnt++;
            }
        }
        if(aCnt == 1 || aCnt == s.length()){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < aCnt; i++) {
            if (s.charAt(i) == 'b') {
                bCnt++;
            }
        }
        int ans = bCnt;
        int n = s.length();
        for (int i = 1; i < s.length(); i++) {
            int out = (i-1)%n;
            int in = (i+aCnt-1)%n;
            if (s.charAt(out) == 'b') {
                bCnt--;
            }
            if (s.charAt(in) == 'b') {
                bCnt++;
            }
            if(bCnt < ans) ans = bCnt;
        }
        System.out.println(ans);
    }
}