import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < R; j++) {
                    sb.append(s.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}