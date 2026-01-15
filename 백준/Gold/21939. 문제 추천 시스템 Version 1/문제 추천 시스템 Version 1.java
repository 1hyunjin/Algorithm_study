import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Question> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            map.put(num, level);
            set.add(new Question(num, level));
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(set.first().num).append("\n");
                }
                else{
                    sb.append(set.last().num).append("\n");
                }
            } else if (op.equals("add")) {
                int n = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                map.put(n, l);
                set.add(new Question(n, l));
            } else{
                int n = Integer.parseInt(st.nextToken());
                int l = map.get(n);
                map.remove(n);
                set.remove(new Question(n, l));
            }
        }
        System.out.println(sb.toString());
    }
    public static class Question implements Comparable<Question>{
        int num;
        int level;

        public Question(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Question o1) {
            if (this.level == o1.level) {
                return o1.num - this.num;
            }
            return o1.level - this.level;
        }
    }
}