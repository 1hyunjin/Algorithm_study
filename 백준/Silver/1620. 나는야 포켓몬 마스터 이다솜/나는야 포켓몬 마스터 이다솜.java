import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            arr[i] = name;
            map.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (map.containsKey(s)) {
                sb.append(map.get(s)).append("\n");
            }
            else{
                sb.append(arr[Integer.parseInt(s)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}