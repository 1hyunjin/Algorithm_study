import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> queue = new ArrayDeque<>();
        int max = 0;
        int minStudent = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.offer(student);
                if (max < queue.size()) {
                    max = queue.size();
                    minStudent = student;
                } else if (max == queue.size()) {
                    minStudent = Math.min(minStudent, student);
                }
            }
            else {
                queue.poll();
            }
        }
        System.out.println(max + " " + minStudent);
    }
}