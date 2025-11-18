import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Mine> pq = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);
        arr = new int[N+1];
        visited = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int power = Integer.parseInt(br.readLine());
            pq.offer(new Mine(i, power));
            arr[i] = power;
        }
        while (!pq.isEmpty()) {
            Mine cur = pq.poll();
            if (!visited[cur.num]) {
                bombLeft(cur.num);
                bombRight(cur.num);
                visited[cur.num] = true;
                list.add(cur.num);
            }
        }
        Collections.sort(list);
        for (int v : list) {
            System.out.println(v);
        }
    }

    public static void bombLeft(int num) {
        while (num - 1 > 0) {
            if (arr[num] > arr[num-1] && !visited[num-1]) {
                visited[num-1] = true;
                num--;
            }
            else{
                break;
            }
        }
    }

    public static void bombRight(int num) {
        while(num+1 <= N){
            if (arr[num] > arr[num + 1] && !visited[num+1]) {
                visited[num+1] = true;
                num++;
            }
            else{
                break;
            }
        }
    }
    public static class Mine {
        int num;
        int p;

        public Mine(int num, int p) {
            this.num = num;
            this.p = p;
        }
    }
}