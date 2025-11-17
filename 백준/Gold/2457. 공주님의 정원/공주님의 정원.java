import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Flower> list = new ArrayList<>();
        Flower[] arr = new Flower[N];
        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            int sMonth = Integer.parseInt(st.nextToken());
            int sDay = Integer.parseInt(st.nextToken());
            int eMonth = Integer.parseInt(st.nextToken());
            int eDay = Integer.parseInt(st.nextToken());
            int start = sMonth * 100 + sDay;
            int end = eMonth * 100 + eDay;
            arr[i] = new Flower(start, end);
        }
        Arrays.sort(arr);

        int cur = 301;
        int target = 1201;
        int cnt = 0;
        int idx = 0;

        while (cur < target) {
            int bEnd = cur;
            while (idx < N && arr[idx].start <= cur) {
                if(arr[idx].end > bEnd) {
                    bEnd = arr[idx].end;
                }
                idx++;
            }
            if(bEnd == cur){
                System.out.println(0);
                return;
            }
            cur = bEnd;
            cnt++;
        }
        System.out.println(cnt);
    }
    public static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) {
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }
}