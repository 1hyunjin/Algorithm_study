import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = 0;
        int p = 0;
        boolean flag = true;
        while (flag) {
            num++;
            String numStr = String.valueOf(num);
            for (int i = 0; i < numStr.length(); i++) {
                if (numStr.charAt(i) == s.charAt(p)) {
                    p++;
                }
                if (p == s.length()) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}