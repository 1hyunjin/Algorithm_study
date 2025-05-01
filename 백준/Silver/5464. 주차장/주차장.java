import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N+1];
        int[] weight = new int[M+1];

        PriorityQueue<Integer> parking = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            parking.offer(i);
        }
        for (int i = 1; i <= M; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> waiting = new ArrayDeque<>();
        int[] arr = new int[M+1];

        int sum = 0;
        for (int i = 1; i <= 2 * M; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                if (parking.isEmpty()) {
                    waiting.offer(num);
                }else {
                    arr[num] = parking.poll();
                }
            }
            else {
                num = Math.abs(num);
                sum += weight[num] * money[arr[num]];

                if (!waiting.isEmpty()) {
                    arr[waiting.poll()] = arr[num];
                } else{
                    parking.offer(arr[num]);
                }
            }
        }
        System.out.println(sum);
    }
}