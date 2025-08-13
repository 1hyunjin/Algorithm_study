import java.util.*;
import java.io.*;

public class Main {
//    static int[] dir = {0, 1, 2, 3}; // 동,남,서,북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String moves = br.readLine();
        int dir = 1; // 남쪽부터 시작
        char[][] map = new char[101][101];
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                map[i][j] = '#';
            }
        }
        int curX = 50;
        int curY = 50;
        map[curX][curY] = '.';
        int minX = 50;
        int minY = 50;
        int maxX = 50;
        int maxY = 50;

        for (int i = 0; i < len; i++) {
            char op = moves.charAt(i);
            if (op == 'R') {
                dir = (dir + 1) % 4;
            }
            else if (op == 'L') {
                dir = (dir + 3) % 4;
            }
            else { // 전진
                curX = curX + dx[dir];
                curY = curY + dy[dir];
                map[curX][curY] = '.';
                minX = Math.min(minX, curX);
                minY = Math.min(minY, curY);
                maxX = Math.max(maxX, curX);
                maxY = Math.max(maxY, curY);
            }
        }
//        System.out.println("minX : " + minX + " , maxX : " + maxX + " , minY : " + minY + " , maxY : " + maxY);
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}