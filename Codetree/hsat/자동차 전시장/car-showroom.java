import java.util.*;
import java.io.*;
public class Main {
    static int N, M, K;
    static List<Integer>[] graph;
    static int[] people;
    static int[] reachCnt;
    static int[] maxTime;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
        }
        people = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        reachCnt = new int[N+1];
        maxTime = new int[N+1];
        for(int start : people){
            bfs(start);
        }
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i = 1; i <= N; i++){
            if(reachCnt[i] == K){
                min = Math.min(min, maxTime[i]);
                flag = true;
            }
        }
        System.out.println(flag ? min : -1);
    }
    public static void bfs(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        dist[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            reachCnt[cur]++;
            maxTime[cur] = Math.max(maxTime[cur], dist[cur]);
            for(int nxt : graph[cur]){
                if(dist[nxt] == -1){
                    dist[nxt] = dist[cur]+1;
                    queue.offer(nxt);
                }
            }
        }
    }
}