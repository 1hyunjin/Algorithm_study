import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Problem> treeSet = new TreeSet<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(num, level);
            treeSet.add(new Problem(num, level));
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                map.put(num, level);
                treeSet.add(new Problem(num, level));
            } else if (op.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    Problem hard = treeSet.last();
                    sb.append(hard.num).append("\n");
                }
                else{
                    Problem easy = treeSet.first();
                    sb.append(easy.num).append("\n");
                }
            } else if (op.equals("solved")) {
                int num = Integer.parseInt(st.nextToken());
                Integer level = map.get(num);
                Problem solved = new Problem(num, level);
                treeSet.remove(solved);
                map.remove(num);
            }
        }
        System.out.println(sb.toString());

    }
    public static class Problem implements Comparable<Problem>{
        int num;
        int level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) {
                return this.num - o.num;
            }
            return this.level - o.level;
        }
    }
}