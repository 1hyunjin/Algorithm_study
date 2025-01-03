import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int N, M;
    static boolean[] isSelected;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = i+1;
        }
        isSelected = new boolean[N];
        result = new int[M];

        perm(0);
    }

    public static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                result[cnt] = num[i];
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }
}