import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.score == o2.score) {
                    return o1.num - o2.num;
                }
                return o2.score - o1.score;
            }
        });
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int score = 0;
            for (int j = 0; j < N; j++) {
                if (st.nextToken().charAt(0) == 'O') {
                    score += arr[j];
                }
            }
            pq.offer(new Student(num, score));
        }
        StringBuilder sb = new StringBuilder();
        Student s = pq.poll();
        sb.append(s.num).append(" ").append(s.score);
        System.out.println(sb.toString());
    }

    public static class Student {
        int num;
        int score;

        public Student(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }
}