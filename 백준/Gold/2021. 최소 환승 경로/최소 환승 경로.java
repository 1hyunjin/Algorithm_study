import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Integer>[] stations= new List[N+1];    // 각 역이 지나는 노선 번호 저장
        List<Integer>[] lines = new List[N+1]; // 노선n번에 포함하는 역 저장
        for (int i = 0; i <= N; i++) {
            stations[i] = new ArrayList<>();
            lines[i] = new ArrayList<>();
        }
        int[] arr = new int[N+1];
        for (int i = 1; i <= L; i++) {
            String[] s = br.readLine().split(" ");
            for (String station : s) {
                int stationNum = Integer.parseInt(station);
                if (stationNum == -1) {
                    break;
                }
                stations[stationNum].add(i);
                lines[i].add(stationNum);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] visitedStat= new boolean[N+1];
        boolean[] visitedLine = new boolean[N+1];
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        visitedStat[start] = true;
        for (int line : stations[start]) { // 역이 가진 노선들 확인
            pq.add(new Point(line, start, 0));
            visitedLine[line] = true;
        }
        boolean isArrived = false;
        while (!pq.isEmpty()) {
            Point cur= pq.poll();
            if (cur.station == end) {
                System.out.println(cur.cnt);
                isArrived = true;
                break;
            }
            for (int next : lines[cur.line]) {
                if (!visitedStat[next]) {
                    visitedStat[next] = true;
                    pq.add(new Point(cur.line, next, cur.cnt));

                    for (int nextLine : stations[next]) {
                        if (!visitedLine[nextLine]) {
                            visitedLine[nextLine] = true;
                            pq.add(new Point(nextLine, next, cur.cnt + 1));
                        }
                    }

                }
            }
        }
        if (!isArrived) {
            System.out.println(-1);
        }
    }
    public static class Point{
        int line;
        int station;
        int cnt;

        public Point(int num, int station, int cnt) {
            this.line = num;
            this.station = station;
            this.cnt = cnt;
        }
    }
}