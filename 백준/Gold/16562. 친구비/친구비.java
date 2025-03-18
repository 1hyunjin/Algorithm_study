import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, k;
    static int[] arr;
    static int[] cost; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        cost = new int[N+1];
        // make 
        for(int i = 0; i <= N; i++){
            arr[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(cost));
        int result = cost[1];
        int min = 0; 
        int ans = 0; 
        boolean isPossible = true;
        out:for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(find(i) != find(j)){
                    result += cost[j];
                    if(result > k){
                        isPossible = false;
                        break out;
                    }
                    else {
                        union(i, j);
                    }
                }
            }
        }
        if(!isPossible){
            System.out.println("Oh no");
        }
        else {
            System.out.println(result);
        }
    }
    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        
        if(a == b){
            return;
        }
        if(cost[a] < cost[b]){
            cost[b] = cost[a];
            arr[b] = a;
        }
        else {
            cost[a] = cost[b];
            arr[a] = b;
        }
    }
    public static int find(int x){
        if(arr[x] == x){
            return x;
        }
        else {
            arr[x] = find(arr[x]);
            cost[x] = cost[find(arr[x])];
        }
        return arr[x];
    }
}