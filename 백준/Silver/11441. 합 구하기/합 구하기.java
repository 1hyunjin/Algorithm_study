import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] map = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            map[i] = num + map[i-1];
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int result = map[j] - map[i-1];
            
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}