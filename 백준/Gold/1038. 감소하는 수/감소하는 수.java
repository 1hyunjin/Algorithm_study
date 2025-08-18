import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 9876543210 : 10자리 2^10 = 1024-1 = 1023번/ 0~1022번까지 (총 1023개)
        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N > 1022) {
            System.out.println(-1);
            return;
        }
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 0부터 9까지 시작점 잡고 bfs 돌림
            dfs(i, 1);
        }
        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void dfs(long num, int idx) { // idx = 자릿수
        // 자릿수가 10자리 넘으면 X
        if (idx > 10) {
            return;
        }
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs((num * 10) + i, idx + 1);
        }
    }
}