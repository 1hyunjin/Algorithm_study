import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>(){
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.start == o2.start) {
                    return o1.end- o2.end;
                }
                return o1.start - o2.start;
            }
        });
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(start, end));
        }
        while (!pq.isEmpty()) {
            Meeting cur = pq.poll();
            for (int i = 0; i < N; i++) {
                if (arr[i] <= cur.start) {
                    arr[i] = cur.end;
                    break;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}