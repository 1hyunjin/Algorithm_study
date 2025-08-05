import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static char[][] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        tmp = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    check(i, j);
                }
            }
        }
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (tmp[i][j] == 'X') {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(row);
        Collections.sort(col);

        int si = row.get(0);
        int ei = row.get(row.size() - 1);
        int sj = col.get(0);
        int ej = col.get(col.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = si; i <= ei; i++) {
            for (int j = sj; j <= ej; j++) {
                sb.append(tmp[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void check(int i, int j) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
                cnt++;
            } else if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                cnt++;
            }
        }
        if (cnt >= 3) {
            tmp[i][j] = '.';
        }
    }
}