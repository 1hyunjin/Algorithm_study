import java.util.*;
import java.io.*;

public class Main {
    static int  r, c, ans;
    static char[][] map;
    static boolean isConnect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        ans = 0;
        for (int i = 0; i < r; i++) {
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    static int[] dx = {-1, 0, 1};

    public static boolean dfs(int x, int y) {

        map[x][y] = 'x';

        if (y == c - 1) {
            ans++;
            return true;
        }

        boolean result = false;

        for (int d = 0; d < 3; d++) {
            int nx = x + dx[d];
            int ny = y + 1;

            if (nx >= 0 && nx < r && ny < c && map[nx][ny] == '.') {
                result = dfs(nx, ny);
                if(result) break;
            }
        }
        return result;
    }
}