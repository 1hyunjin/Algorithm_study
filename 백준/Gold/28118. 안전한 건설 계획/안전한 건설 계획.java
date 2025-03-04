import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        // make set
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        int target = 1;
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (find(target) != find(i)) {
                union(target, i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootX = find(a);
        int rootY = find(b);

        if (rootX == rootY) {
            return;
        }
        if (rootX < rootY) {
            arr[rootY] = rootX;
        }
        else {
            arr[rootX] = rootY;
        }
    }

    public static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]); // 경로 압축
    }
}