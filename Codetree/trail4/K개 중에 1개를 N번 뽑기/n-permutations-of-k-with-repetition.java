import java.io.*;
import java.util.*;

public class Main {
    static int[] result;
    static int K, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = new int[N];
        perm(0);
    }
    public static void perm(int idx){
        if(idx == N){
            for(int i = 0; i < N; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= K; i++){
            result[idx] = i;
            perm(idx+1);
        }
    }
}