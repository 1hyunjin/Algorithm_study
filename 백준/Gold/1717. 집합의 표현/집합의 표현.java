import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for(int i = 0; i <= n; i ++){
            makeSet(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(a, b);
            }
            else {
                if (find(a) != find(b)) {
                    sb.append("NO").append("\n");
                }
                else {
                    sb.append("YES").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
    public static void makeSet(int x){
        arr[x] = x; // 자기 자신을 부모(root)로 전처리
    }

    public static void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        else {
            arr[find(b)] = arr[find(a)];
        }
    }

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        else {
            return arr[x] = find(arr[x]);
        }
    }
}