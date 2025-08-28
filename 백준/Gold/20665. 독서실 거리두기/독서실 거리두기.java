import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 자리
        int T = Integer.parseInt(st.nextToken());   // 예약 수
        int P = Integer.parseInt(st.nextToken());   // 민규 좌석번호
        Info[] rooms = new Info[N + 1];
        boolean[] used = new boolean[N + 1]; // 사용 여부?
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.in != o2.in) {
                    return o1.in - o2.in;
                }
                int diff1 = o1.out - o1.in;
                int diff2 = o2.out - o2.in;
                return diff1 - diff2;
            }
        });
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String in = st.nextToken();
            int in1 = Integer.parseInt(in.substring(0, 2)) * 60 + Integer.parseInt(in.substring(2, 4));

            String out = st.nextToken();
            int out1 = Integer.parseInt(out.substring(0, 2)) * 60 + Integer.parseInt(out.substring(2, 4));
            pq.offer(new Info(in1, out1));
        }
        int start = 9 * 60; // 9시 = 540분
        int end = 21 * 60;
        int c = 0;  // 앉아있는사람
        int ming = 0; // 민규가 앉아있을 수 있는 시간
        int free = start; // P가 마지막으로 비어져있는 시간
        while (!pq.isEmpty()) {
            Info cur = pq.peek(); // 들어올 사람
            // 퇴실 시키기
            for (int i = 1; i <= N; i++) {
                if (used[i] && rooms[i] != null && rooms[i].out <= cur.in) {
                    used[i] = false;
                    if (i == P) {
                        free = rooms[i].out;
                    }
                    rooms[i] = null;
                    c--;
                }
            }

            int dist = 0;
            int seat = 0;
            for (int i = 1; i <= N; i++) {
                if (!used[i]) { // 비어있는 자리라면
                    int minDist = Integer.MAX_VALUE;
                    // 왼쪽
                    for (int j = i-1; j >= 1; j--) {
                        if (used[j]) {
                            minDist = Math.min(minDist, i - j);
                            break;
                        }
                    }
                    // 오른쪽
                    for (int j = i + 1; j <= N; j++) {
                        if (used[j]) {
                            minDist = Math.min(minDist, j - i);
                            break;
                        }
                    }
                    if (minDist > dist || (minDist == dist && i < seat)) {
                        dist = minDist;
                        seat = i;
                    }
                }
            }
            // 앉혀
            cur = pq.poll();
            // P가 비어져있었고 cur이 P에 앉는다면 빈 시간 더해
            if (seat == P) {
                ming += cur.in-free;
            }
            used[seat] = true;
            rooms[seat] = new Info(cur.in, cur.out);
            c++;
        }
        if (!used[P]) {
            ming += Math.max(0, end-free);
        } else{
            // 마지막 사람이 쓰고 있었음.
            if (rooms[P].out < end) {
                ming += end - rooms[P].out;
            }
        }
        System.out.println(ming);
    }

    public static class Info {
        int in; // 입실 시간
        int out; // 퇴실 시간

        public Info(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}
