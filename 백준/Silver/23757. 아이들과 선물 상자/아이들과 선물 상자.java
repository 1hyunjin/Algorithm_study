import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] boxes = new int[N];
        int[] children = new int[M];

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            children[i] = Integer.parseInt(st.nextToken());
        }
        boolean isGet = true;
        for (int i = 0; i < M; i++) {
            Integer presents = pq.poll();
            if (children[i] > presents) {
                isGet = false;
                break;
            }
            else {
                int left = presents-children[i];
                if (left != 0) {
                    pq.offer(left);
                }
            }
        }
        if(!isGet){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }
}