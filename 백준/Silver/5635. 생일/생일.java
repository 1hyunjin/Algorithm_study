import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.year == o2.year) {
                    if (o1.month == o2.month) {
                        return o2.day - o1.day;
                    }
                    return o2.month - o1.month;
                }
                return o2.year - o1.year;
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            pq.offer(new Info(name, day, month, year));
        }
        if (pq.size() == 1) {
            String name = pq.poll().name;
            System.out.println(name);
            System.out.println(name);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pq.poll().name).append("\n");
        while (pq.size() > 1) {
            pq.poll();
        }
        sb.append(pq.poll().name);
        System.out.println(sb);
    }

    public static class Info {
        String name;
        int day;
        int month;
        int year;

        public Info(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}