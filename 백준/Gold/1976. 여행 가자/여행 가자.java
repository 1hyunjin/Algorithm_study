import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] plan;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        plan = new int[M];

        List<Integer>[] graph = new List[N+1];
        for(List<Integer> list : graph){
            list = new ArrayList<>();
        }
        arr = new int[N+1];

        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1 && i != j) {
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
        boolean isPossible = true;
        for (int i = 0; i < M-1; i++) {
            if (find(plan[i]) != find(plan[i + 1])) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            arr[y] = arr[x];
        }
    }

    public static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}