import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; // N, S, W, E
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        
        char[][] map = new char[n][m];
        int cx = 0;
        int cy = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    cx = i;
                    cy = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] arr = route.split(" ");
            String op = arr[0];
            int cnt = Integer.parseInt(arr[1]);
            
            int dir = 0;
            
            if (op.equals("N")) {
                dir = 0;
            } else if (op.equals("S")) {
                dir = 1;
            } else if (op.equals("W")) {
                dir = 2;
            } else {
                dir = 3;
            }
            
            boolean canMove = true;
            int nx = cx;
            int ny = cy;
            
            for (int i = 0; i < cnt; i++) {
                nx += dx[dir];
                ny += dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                cx = nx;
                cy = ny;
            }
        }
        int[] answer = new int[2];
        answer[0] = cx;
        answer[1] = cy;
        return answer;
    }
}