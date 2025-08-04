import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Point[] arr = new Point[N+1];

        arr[0] = new Point(0, 0);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= 1; j--) {
                // 물건의 무게가 가방의 무게보다 클 때..?
                if(arr[i].w > j){
                   continue;
                }
                // 물건의 무게가 가방의 무게보다 같거나 작을 때?
                if (arr[i].w <= j) {
                    dp[j] = Math.max(dp[j], dp[j - arr[i].w] + arr[i].v);
                }
            }
        }

        System.out.println(dp[K]);

    }

    public static class Point {
        int w;
        int v;

        public Point(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

}