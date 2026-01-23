import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        sb = new StringBuilder();
        comb(1, 0);
        System.out.println(sb.toString());
    }

    public static void comb(int idx, int cnt) {
        if(cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i <= N; i++) {
            result[cnt] = i;
            comb(i,cnt+1);
        }
    }
}