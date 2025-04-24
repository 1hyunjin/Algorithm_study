import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int dasom = arr[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 1; i < N; i++) {
            pq.offer(arr[i]);
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            Integer vote = pq.poll();
            if (dasom <= vote) {
                dasom++;
                vote--;
                cnt++;
                pq.offer(vote);
            }
            else {
                break;
            }
        }
        System.out.println(cnt);
    }
}