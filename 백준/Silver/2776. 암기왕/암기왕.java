import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> note1 = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (note1.contains(num)) {
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}