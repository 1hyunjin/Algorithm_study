import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(0);
        } else {
            int n1 = arr[0];
            int n2 = arr[1];

            int min = Integer.MAX_VALUE;
            for (int d1 = -1; d1 <= 1; d1++) {
                for (int d2 = -1; d2 <= 1; d2++) {
                    int b1 = n1 + d1;
                    int b2 = n2 + d2;
                    int d = b2 - b1; // 등차
                    int cnt = 0;

                    if (d1 != 0) cnt++;
                    if (d2 != 0) cnt++;

                    boolean isChanged = true;
                    for (int i = 2; i < N; i++) {
                        int exp = b1 + i * d;
                        if (Math.abs(arr[i] - exp) > 1) {
                            isChanged = false;
                            break;
                        }
                        if (arr[i] != exp) {
                            cnt++;
                        }
                    }
                    if (isChanged) {
                        min = Math.min(min, cnt);
                    }
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }
}