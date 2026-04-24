import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int minCnt = Integer.MAX_VALUE;
    static int max = 0;
    static long[] guitar;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitar = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            char[] chArr = st.nextToken().toCharArray();
            for (int j = M-1; j >=0; j--) {
                if(chArr[j] == 'Y'){
                    guitar[i] |= (1L << M-1-j);
                }
            }
        }
        comb(0, 0L, 0);
        if (minCnt == 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(minCnt);
        }
    }

    public static void comb(int idx, long mask, int cnt) {
        int bitCnt = Long.bitCount(mask);
        if (bitCnt == max && cnt < minCnt) {
            minCnt = cnt;
        }
        if (bitCnt > max) {
            max = bitCnt;
            minCnt= cnt;
        }
        if (bitCnt == M || idx == N) {
            return;
        }

        comb(idx + 1, mask | guitar[idx], cnt + 1);
        comb(idx+1, mask, cnt);
    }
}