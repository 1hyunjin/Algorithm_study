import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;
    static int[][] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        prefix = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = Integer.parseInt(st.nextToken()) + prefix[i][j-1] + prefix[i-1][j] - prefix[i-1][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int result = getPrefixSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int getPrefixSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
    }
}