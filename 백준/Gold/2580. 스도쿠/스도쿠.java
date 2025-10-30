import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static List<Integer> blank;
    static boolean isPossible;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        blank = new ArrayList<>();
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blank.add(i * 9 + j);
                }
            }
        }
        isPossible = false;
        dfs(0);
    }

    public static void dfs(int idx) {
        if(idx == blank.size()){
            isPossible = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        if(isPossible){
            return;
        }
        int cur = blank.get(idx);
        int x = cur/9;
        int y= cur%9;
        for(int num = 1; num <= 9; num++){
            if(check(x, y, num)){
                map[x][y] = num;
                dfs(idx+1);
                if(isPossible){
                    return;
                }
                map[x][y] = 0;
            }
        }
    }

    public static boolean check(int x, int y, int num) {

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) {
                return false;
            }
            if (map[i][y] == num) {
                return false;
            }
        }
        int rx = (x/3)*3;
        int ry = (y/3)*3;

        for(int i = rx; i < rx+3; i++){
            for(int j = ry; j < ry + 3; j++){
                if(map[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}