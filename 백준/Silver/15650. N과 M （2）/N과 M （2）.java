import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];

        comb(0, 0);
    }

    public static void comb(int idx, int cnt) {

        if (cnt == M) {
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
            return;
        }

        if (idx == N) {
            return;
        }

        isSelected[idx] = true;
        comb(idx+1, cnt+1);
        isSelected[idx] = false;
        comb(idx + 1, cnt);
    }
}