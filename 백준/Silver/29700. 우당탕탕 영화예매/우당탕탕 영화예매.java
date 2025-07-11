import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] chairs = new int[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                int chair = s.charAt(j)-'0';
                if (chair == 1) {
                    cnt = 0;
                }
                else{
                    cnt++;
                    if(cnt >= K){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}