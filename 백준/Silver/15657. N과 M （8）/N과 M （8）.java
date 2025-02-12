import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] isSelected;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        comb(0, 0);
        System.out.println(sb.toString());
    }

    public static void comb(int idx, int num) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = num; i < N; i++) {
            result[idx] = arr[i];
            comb(idx + 1, i);
        }
    }
}