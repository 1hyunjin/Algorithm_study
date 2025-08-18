import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[] arr;
    static boolean[] isSelected;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        max = 0;
        isSelected = new boolean[N];
        result = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(max);
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                result[cnt] = arr[i];
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}