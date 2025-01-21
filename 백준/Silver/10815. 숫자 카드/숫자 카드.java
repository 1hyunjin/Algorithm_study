import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}