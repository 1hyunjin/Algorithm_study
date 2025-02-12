import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static int r, c;
    static Point red;
    static Point green;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        int answer = 0;
        r = board.length;
        c = board[0].length();
        map = new char[r][c];
        
        visited = new boolean[r][c];
        
        for(int i = 0; i < r; i++){
            String str = board[i];
            for(int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    red = new Point(i, j);
                }
                else if( map[i][j] == 'G'){
                    green = new Point(i, j);
                }
            }
        }
        answer = bfs(red.x, red.y);
        return answer;
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    
    public static int bfs(int x, int y ){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int time = 0;
        
        out:while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println("size : " + size);
            for(int s = 0; s < size; s++){
                
                Point cur = queue.poll();
                // System.out.println("cur : " + cur.x + " ," + cur.y);
                
                if(cur.x == green.x && cur.y == green.y){
                    return time;
                    // System.out.println("finala time : " + time);
                    // break out;
                }
                
                for(int d = 0; d < 4; d++){
                    Point point = move(cur.x, cur.y, d);
                    
                    // if(point.x != cur.x || point.y != cur.y || !visited[point.x][point.y]){
                    if(!visited[point.x][point.y]){
                        // System.out.println("time : " + time + " "+ point);
                        queue.add(point);
                        visited[point.x][point.y] = true;
                    }
                }
            }
            time++;
        } 
        return -1;
    }
    public static Point move(int x, int y, int dir){
        
        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == 'D'){
                break;
            }
            
            x = nx;
            y = ny;
        }
        return new Point(x, y);
    }
    
    public static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "Point{" + this.x + " ," + this.y + "}";
        }
    }
    
    public static void print(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}