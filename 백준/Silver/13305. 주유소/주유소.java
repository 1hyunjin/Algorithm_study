import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] road = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        int[] oil = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oil[i] = Integer.parseInt(st.nextToken());
        }
        int minCost = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int cost = oil[i];
            if (minCost > cost) {
                minCost = cost;
            }
            sum += (long) minCost * road[i];
        }
        System.out.println(sum);
    }
}