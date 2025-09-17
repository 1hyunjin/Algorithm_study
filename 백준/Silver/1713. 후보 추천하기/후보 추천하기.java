import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, Picture> map = new HashMap<>();
        TreeSet<Picture> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            Picture cur = map.get(num);
            if (cur != null) {
                // 액자에 있는거
                set.remove(cur);
                cur.cnt++;
                set.add(cur);
            }
            else{
                if (set.size() == N) {
                    Picture del = set.first();
                    set.remove(del);
                    map.remove(del.student);
                }
                Picture next = new Picture(num, 1, i);
                set.add(next);
                map.put(num, next);
            }
        }

        List<Integer > list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static class Picture implements Comparable<Picture>{
        int student;
        int cnt;
        int idx;

        public  Picture(int student, int cnt, int idx) {
            this.student = student;
            this.cnt = cnt;
            this.idx = idx;
        }

        @Override
        public int compareTo(Picture o) {
            if (this.cnt == o.cnt) {
                return this.idx - o.idx;
            }
            return this.cnt - o.cnt;
        }
    }
}