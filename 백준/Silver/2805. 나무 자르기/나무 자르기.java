import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        long s = 0;
        long e = trees[N-1];
        long max = trees[N-1];
        while (s <= e) {
            long mid = (s+e+1)/2;
            if (cut(mid)) {
                s = mid+1;
                max = mid;
            }
            else{
                e = mid-1;
            }
        }
        System.out.println(max);
    }

    public static boolean cut(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] >= mid) {
                sum += trees[i] - mid;
            }
        }
        if (sum >= M) {
            return true;
        }
        else{
            return false;
        }
    }
}