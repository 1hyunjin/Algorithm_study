import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        len = 0;
        sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                len++;
            }
            else{
                if (len == 1) {
                    System.out.println(-1);
                    return;
                } else if (len > 1) {
                    if (!trans()) {
                        System.out.println(-1);
                        return;
                    }
                }
                sb.append(".");
            }
        }
        if (len > 1) {
            if (!trans()) {
                System.out.println(-1);
                return;
            }
        }
        else if(len == 1){
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());
    }

    public static boolean trans() {
        while (len > 0) {
            if (len == 1) {
                return false;
            } else if (len >= 4) {
                sb.append("AAAA");
                len-=4;
            } else if (len >= 2) {
                sb.append("BB");
                len-=2;
            }
        }
        return true;
    }
}