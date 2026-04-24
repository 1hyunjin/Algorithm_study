import java.io.*;
import java.util.*;

class Main {
    static int min = Integer.MAX_VALUE;
    static int[] cols;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 'T') {
                    cols[j] |= (1 << i);
                }
            }
        }
        for (int mask = 0; mask < (1 << N); mask++) {
            int totalT = 0;
            for (int j = 0; j < N; j++) {
                int flippedCol = cols[j]^mask;
                int top = Integer.bitCount(flippedCol);
                // T가 많으면 뒤집는게 이득
                totalT += Math.min(top, N - top);
            }
            min = Math.min(min, totalT);
        }
        System.out.println(min);
    }
}