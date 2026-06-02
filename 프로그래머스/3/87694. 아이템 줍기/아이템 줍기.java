import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        for(int[] arr : rectangle){
            int x1 = arr[0] * 2;
            int y1 = arr[1] * 2;
            int x2 = arr[2] * 2;
            int y2 = arr[3] * 2;
            
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    
                    if(i > x1 && i < x2 && j > y1 && j < y2){
                        map[i][j] = 2; // 내부
                    }
                    else{
                        if(map[i][j] != 2){
                            map[i][j] = 1; // 테두리 후보
                        }
                    }
                }
            }
        }
        // for(int i = 0; i < 101; i++){
        //     for(int j = 0; j < 101; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        Queue<Point> queue = new ArrayDeque<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        queue.add(new Point(characterX*2, characterY*2));
        visited[characterX*2][characterY*2] = true;
        int turn = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                Point cur = queue.poll();
                if(cur.x == itemX*2 && cur.y == itemY*2){
                    return turn/2;
                }
                for(int d = 0; d < 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && map[nx][ny] == 1 && !visited[nx][ny]){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }   
            }
            turn++;
        }
        return answer;
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}