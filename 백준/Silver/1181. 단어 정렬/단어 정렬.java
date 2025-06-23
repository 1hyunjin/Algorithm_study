import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return a.length()-b.length();
            }
        });
        for (String s : set) {
            pq.offer(s);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}