import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] arr = s.split("\\*");
        String first = arr[0];
        String second = arr[1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String next = br.readLine();
            if (next.length() < first.length() + second.length()) {
                sb.append("NE").append('\n');
                continue;
            }
            if (next.substring(0, first.length()).equals(first)) {
                if (next.substring(next.length() - second.length(), next.length()).equals(second)) {
                    sb.append("DA").append('\n');
                    continue;
                }
            }
            sb.append("NE").append('\n');
        }
        System.out.println(sb.toString());
    }
}