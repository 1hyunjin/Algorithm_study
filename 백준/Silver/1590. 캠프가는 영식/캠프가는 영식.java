import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            for(int j = 0; j < C; j++){
                int start = S + I * j;
                if (T <= start) {
                    min = Math.min(min, start-T);
                    break;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
    }
}