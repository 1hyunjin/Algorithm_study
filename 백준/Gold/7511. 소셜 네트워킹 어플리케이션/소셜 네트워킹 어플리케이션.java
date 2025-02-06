import java.io.*;
import java.util.*;

public class Main {
    static int n, k, m;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {

            sb.append("Scenario ").append(tc).append(":").append("\n");

            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            arr = new int[n];
            // makeset
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (find(x) == find(y)) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
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