import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int time = 24*N; // 총 시간
        int[] subject = new int[M];
        int[] score = new int[M];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            subject[i] = Integer.parseInt(st.nextToken());
            total += subject[i]; // 총합
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < M; i++) {
            int diff = 100-subject[i];
            int moc = diff/score[i];   // 몫
            int left = diff%score[i]; // 나머지
            for (int j = 0; j < moc; j++) {
                pq.offer(score[i]);
            }
            if (left != 0) {
                pq.offer(left);
            }
        }
        while (time-- > 0 && !pq.isEmpty()) {
            total+=pq.poll();
        }
        System.out.println(total);
    }
}