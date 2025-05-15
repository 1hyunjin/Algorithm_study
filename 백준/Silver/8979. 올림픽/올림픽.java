import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Score[] score = new Score[N];
        int[] prize = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int dong = Integer.parseInt(st.nextToken());
            score[i] = new Score(num, gold, silver, dong);

        }
        Arrays.sort(score);
        int[] cnt = new int[N + 1];
        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                prize[score[i].num] = 1;
                cnt[prize[score[i].num]]++;
                prev = prize[score[i].num];
            } else {
                if (score[i - 1].gold == score[i].gold && score[i - 1].silver == score[i].silver && score[i - 1].dong == score[i].dong) {
                    prize[score[i].num] = prev;
                    cnt[prize[score[i].num]]++;
                } else {
                    prize[score[i].num] = prev + cnt[prev];
//                    prize[i] = prize[i - 1] + cnt[prize[i - 1]];
                    cnt[prize[score[i].num]]++;
                    prev = prize[score[i].num];
                }
            }
        }
        System.out.println(prize[K]);
    }

    public static class Score implements Comparable<Score> {
        int num;
        int gold;
        int silver;
        int dong;

        public Score(int num, int gold, int silver, int dong) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.dong = dong;
        }

        @Override
        public int compareTo(Score o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.dong - this.dong;
                } else return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }

        @Override
        public String toString() {
            return "Score{ " + this.num + " , " + this.gold + " , " + this.silver + " , " + this.dong + " }";
        }
    }
}