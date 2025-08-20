import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] life = new int[N+1];
        for (int i = 1; i <= N; i++) {
            life[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] joy = new int[N+1];
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }
        int[][] arr = new int[N+1][101];
        Arrays.fill(arr[0], 0);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100; j++) {
                if (life[i] > j) {
                    arr[i][j] = arr[i-1][j];
                } else if (life[i] <= j) {
                    arr[i][j] = Math.max(arr[i - 1][j - life[i]] + joy[i], arr[i - 1][j]);
                }
            }
        }
        System.out.println(arr[N][99]);
    }
}