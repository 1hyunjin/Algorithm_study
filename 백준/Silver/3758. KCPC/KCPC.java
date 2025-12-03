import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int teamID = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n+1][k+1];
            int[] cnt = new int[n+1];
            int[] order = new int[n+1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                map[id][num] = Math.max(map[id][num], score);
                cnt[id]++;
                order[id] = i;
            }
            PriorityQueue<Team> pq = new PriorityQueue<>(new Comparator<Team>(){
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.score == o2.score) {
                        if (o1.cnt == o2.cnt) {
                            return o1.time - o2.time;
                        }
                        return o1.cnt - o2.cnt;
                    }
                    return o2.score - o1.score;
                }
            });
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += map[i][j];
                }
                pq.offer(new Team(i, sum, cnt[i], order[i]));
            }
            int result = 1;
            while (!pq.isEmpty()) {
                Team cur = pq.poll();
                if(cur.id == teamID){
                    sb.append(result).append("\n");
                    break;
                }
                else{
                    result++;
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static class Team{
        int id;
        int score;
        int cnt;
        int time;

        public Team(int id, int score, int cnt, int time) {
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }
    }
}