import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= C - 3; i++) {
            for (int j = 0; j <= R - 3; j++) {
                int sum = 0;
                List<Integer> list = new ArrayList<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        list.add(map[l][k]);
                    }
                }
                Collections.sort(list);
                int mid = list.get(list.size() / 2);
                result.add(mid);
            }
        }
        int answer = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) >= T) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}