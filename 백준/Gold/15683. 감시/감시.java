import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static List<CCTV> cctvList;
    static int[] result;
    static int min;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cctvList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        min = Integer.MAX_VALUE; // 0의 개수

        result = new int[cctvList.size()];
        subset(0);

        System.out.println( min );
    }

    public static void subset(int cnt) {

        if(cnt == cctvList.size()){
            // 이 result 배열을 가지고 감시하는 곳 봐야겠지??
            check(result);
            return;
        }

        for (int d = 1; d <= 4; d++) {
            if (d == 2) {
                if (cctvList.get(cnt).num == 5) {
                    break;
                }
            }
            if (d == 3) {
                if (cctvList.get(cnt).num == 2) {
                    break;
                }
            }
            result[cnt] = d;
            subset(cnt+1);
        }
    }

    public static void check(int[] result) {
        copyMap = new int[n][m];
        deepCopy(map);
        int cnt = 0;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                right(cctvList.get(i));

                if (cctvList.get(i).num == 2 || cctvList.get(i).num == 4 || cctvList.get(i).num == 5) {
                    left(cctvList.get(i));
                }
                if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4 || cctvList.get(i).num == 5) {
                    up(cctvList.get(i));
                }
                if (cctvList.get(i).num == 5) {
                    down(cctvList.get(i));
                }
            }
            if (result[i] == 2) {
                down(cctvList.get(i));
                if (cctvList.get(i).num == 2 || cctvList.get(i).num == 4 ) {
                    up(cctvList.get(i));
                }
                if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4 ) {
                    right(cctvList.get(i));
                }
            }
            if (result[i] == 3) {
                left(cctvList.get(i));
                if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4 ) {
                    down(cctvList.get(i));
                }
                if (cctvList.get(i).num == 4) {
                    right(cctvList.get(i));
                }
            }
            if (result[i] == 4) {
                up(cctvList.get(i));
                if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4 ) {
                    left(cctvList.get(i));
                }
                if (cctvList.get(i).num == 4) {
                    down(cctvList.get(i));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);
    }

    public static void right(CCTV cctv) {
        int ny = cctv.y + 1;
        while (ny < m) {
            if (copyMap[cctv.x][ny] == 6) {
                break;
            }
            if (copyMap[cctv.x][ny] == 0) {
                copyMap[cctv.x][ny] = 7;
            }
            ny++;
        }
    }
    public static void left(CCTV cctv) {
        int ny = cctv.y - 1;
        while (ny >= 0) {
            if (copyMap[cctv.x][ny] == 6) {
                break;
            }
            if (copyMap[cctv.x][ny] == 0) {
                copyMap[cctv.x][ny] = 7;
            }
            ny--;
        }
    }
    public static void up(CCTV cctv) {
        int nx = cctv.x - 1;
        while (nx >= 0) {
            if (copyMap[nx][cctv.y] == 6) {
                break;
            }
            if (copyMap[nx][cctv.y] == 0) {
                copyMap[nx][cctv.y] = 7;
            }
            nx--;
        }
    }
    public static void down(CCTV cctv) {
        int nx = cctv.x + 1;
        while (nx < n) {
            if (copyMap[nx][cctv.y] == 6) {
                break;
            }
            if (copyMap[nx][cctv.y] == 0) {
                copyMap[nx][cctv.y] = 7;
            }
            nx++;
        }
    }

    public static void deepCopy(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    public static class CCTV{
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public String toString() {
            return "{CCTV :" + num + "번 CCTV" + this.x + " , " + this.y + "}";
        }
    }
}