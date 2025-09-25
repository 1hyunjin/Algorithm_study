import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] isClean;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        isClean = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int roomCnt = 0;

        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        while (true) {
            if (map[rx][ry] == 0 && !isClean[rx][ry]) {
                isClean[rx][ry] = true; // 청소하기
                roomCnt++;
            }
            boolean isLeft = false; // 청소할게 남아있는지 확인
            for (int d = 0; d < 4; d++) {
                int nx = rx + dx[d];
                int ny = ry + dy[d];
                if (nx >= 1 && nx < N-1 && ny >= 1 && ny < M-1 && map[nx][ny] == 0 && !isClean[nx][ny]) {
                    isLeft = true; // 청소할 칸이 존재.
                    break;
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!isLeft) {
                int backX = rx + dx[(dir + 2) % 4];
                int backY = ry + dy[(dir + 2) % 4];
                // 후진할 수 없음 -> 뒤쪽 칸이 벽인 경우 -> 작동 종료
                if (map[backX][backY] == 1) {
                    break;
                }
                // 바라보는 방향을 유지한 채로 한칸 후진 가능 -> 한 칸 후진 & 1번으로.
                else {
                    rx = backX;
                    ry = backY;
                }
            }
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 존재하는 경우
            else {
                // 반시계 방향으로 회전
                dir = (dir+3)%4;
                int nx = rx + dx[dir];
                int ny = ry + dy[dir];
                if (nx >= 1 && nx < N-1 && ny >= 1 && ny < M-1 && map[nx][ny] == 0 && !isClean[nx][ny]) {
                    rx = nx;
                    ry = ny;
                }
            }
        }
        System.out.println(roomCnt);
    }
}