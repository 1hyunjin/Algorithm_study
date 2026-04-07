import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            Map<Long, Integer> map = new HashMap<>();
            for (int t = 0; t < T; t++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            boolean isControl = false;
            for (long key : map.keySet()) {
                int val = map.get(key);
                if(val > T/2){
                    isControl = true;
                    sb.append(key).append('\n');
                    break;
                }
            }
            if (!isControl) {
                sb.append("SYJKGW").append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}