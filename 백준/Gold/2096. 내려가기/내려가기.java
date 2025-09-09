import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] minArr = new int[N+1][3];
        int[][] maxArr = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            minArr[i][0] += Math.min(minArr[i-1][0], minArr[i-1][1]) + arr[i][0];
            minArr[i][1] += Math.min(Math.min(minArr[i-1][0], minArr[i-1][1]), minArr[i-1][2]) + arr[i][1];
            minArr[i][2] += Math.min(minArr[i-1][1], minArr[i-1][2]) + arr[i][2];

            maxArr[i][0] += Math.max(maxArr[i-1][0], maxArr[i-1][1]) + arr[i][0];
            maxArr[i][1] += Math.max(Math.max(maxArr[i-1][0], maxArr[i-1][1]), maxArr[i-1][2]) + arr[i][1];
            maxArr[i][2] += Math.max(maxArr[i-1][1], maxArr[i-1][2]) + arr[i][2];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minArr[N][i]);
            max = Math.max(max, maxArr[N][i]);
        }
        System.out.println(max + " " + min);
    }
}