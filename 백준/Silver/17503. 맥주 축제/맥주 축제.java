import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 축제 기간
        int M = Integer.parseInt(st.nextToken()); // 선호도 합
        int K = Integer.parseInt(st.nextToken()); // 맥주 종류 개수

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        Beer[] arr = new Beer[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int good = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            arr[i] = new Beer(good, level);
        }
        Arrays.sort(arr);

        int result = -1;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum+= arr[i].good;
            pq.add(arr[i].good);
            if (pq.size() > N) {
                sum -= pq.poll();
            }
            if (pq.size() == N && sum >= M) {
                result = arr[i].level;
                break;
            }
        }
        System.out.println(result);
    }
    public static class Beer implements Comparable<Beer>{
        int good;
        int level;

        public Beer(int good, int level) {
            this.good = good;
            this.level = level;
        }
        @Override
        public String toString() {
            return "Beer{ " + this.good + " , " + this.level + " }";
        }

        @Override
        public int compareTo(Beer o) {
            return this.level - o.level;
        }
    }
}