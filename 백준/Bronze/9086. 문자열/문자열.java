import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int len = s.length();
            sb.append(s.charAt(0)).append(s.charAt(len - 1)).append('\n');
        }
        System.out.println(sb.toString());
    }
}