import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int func = Integer.parseInt(st.nextToken());
            int name = Integer.parseInt(st.nextToken());
            map.put(func, name);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < R; j++) {
                int s = Integer.parseInt(st.nextToken());
                if (map.containsKey(s)) {
                    sb.append(map.get(s)).append(" ");
                }
                else {
                    result.append("YOU DIED").append("\n");
                    sb.setLength(0);
                    break;
                }
            }
            if (!(sb.length() == 0)) {
                result.append(sb).append("\n");
            }
        }
        System.out.println(result.toString());
    }
}