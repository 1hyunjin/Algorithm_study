import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static int[] num;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i+1;
        }
        sb = new StringBuilder();

        comb(0, 0);

        System.out.println(sb.toString());
    }

    public static void comb(int cnt, int idx) {

        if (cnt == M) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        if (idx == N) {
            return;
        }

        result[cnt] = num[idx];
        comb(cnt + 1, idx);
        comb(cnt, idx+1);

    }
}