import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N+1];
        arr = new int[M];
        sb = new StringBuilder();
        perm(0);
        System.out.println(sb.toString());
    }
    public static void perm(int cnt){
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                arr[cnt] = i;
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}