import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            for (int i = 0; i < arr.length; i++) {
                StringBuilder tmp = new StringBuilder(arr[i]);
                sb.append(tmp.reverse()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
