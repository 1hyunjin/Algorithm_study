import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int waistX, waistY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int heartX = 0;
        int heartY = 0;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        waistX = 0;
        waistY = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        out:for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '_') {
                            break;
                        }
                        heartX = i+1;
                        heartY = j + 1;
                        break out;
                    }
                }
            }
        }
        leftArm = findLeftArm(heartX-1, heartY-1);
        rightArm = findRightArm(heartX-1, heartY-1);
        waist = findWaist(heartX-1, heartY-1);
        leftLeg = findLeftLeg(waistX + 1, waistY - 1);
        rightLeg = findRightLeg(waistX + 1, waistY + 1);
        System.out.println(heartX + " " + heartY);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
    public static int findRightLeg(int x, int y){
        int cnt = 0;
        for(int i = x; i < N; i++){
            if (map[i][y] == '*') {
                cnt++;
            }
            else {
                break;
            }
        }
        return cnt;
    }
    public static int findLeftLeg(int x, int y) {
        int cnt = 0;
        for (int i = x; i < N; i++) {
            if (map[i][y] == '*') {
                cnt++;
            }
            else {
                break;
            }
        }
        return cnt;
    }

    public static int findWaist(int x, int y) {
        int cnt = 0;
        for (int i = x + 1; i < N; i++) {
            if (map[i][y] == '*') {
                cnt++;
                waistX = i;
                waistY = y;
            }
            else {
                break;
            }
        }
        return cnt;
    }
    public static int findLeftArm(int x, int y) {
        int cnt = 0;
        for (int i = y-1; i >= 0; i--) {
            if (map[x][i] == '*') {
                cnt++;
            }
            else{
                break;
            }
        }
        return cnt;
    }

    public static int findRightArm(int x, int y) {
        int cnt = 0;
        for (int i = y + 1; i < N; i++) {
            if (map[x][i] == '*') {
                cnt++;
            }
            else {
                break;
            }
        }
        return cnt;
    }
}