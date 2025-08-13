import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int M = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int num = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                map.put(w, num);
            }
            else{
                int w = Integer.parseInt(st.nextToken());
                sb.append(map.get(w)).append("\n");
            }
        }
        System.out.println(sb);
    }
}