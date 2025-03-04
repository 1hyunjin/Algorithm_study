import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        // 전처리
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b를 합친다!
            if (order == 0) {
                union(a, b);
            }
            else {
                if (find(a) == find(b)) {
                    sb.append("YES").append("\n");
                } else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    // union : x와 y를 포함하는 두 집합을 통합하는 연산
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
        return arr[x] = find(arr[x]); // 경로 압축
    }
}