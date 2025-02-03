import java.util.*;
import java.io.*;

class Solution {
    static char[][] arr;
    static int result;
    public int solution(String[] maps) {
        int answer = 0;
        result = 0;
        Point start = new Point(0,0);
        Point lever = new Point(0,0);
        
        arr = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'S'){
                    start = new Point(i, j);
                }
                if(arr[i][j] == 'L'){
                    lever = new Point(i, j);
                }
            }
        }

        
        int first = bfs(arr, start);
        if(first == -1){
            return -1;
        }
        // System.out.println("first : " + first);
        int second = findExit(arr, lever);
        if(second == -1){
            return -1;
        }
        answer = first + second;
        return answer;
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean findLever;
    
    public static int bfs(char[][] arr, Point start){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        queue.add(start);
        visited[start.x][start.y] = true;
        int turn = 0;
        findLever = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                Point cur = queue.poll();
                if(arr[cur.x][cur.y] == 'L'){
                    // result += turn;
                    // findLever = true;
                    // findExit(arr, cur);
                    return turn;
                    // break;
                }
                for(int d = 0; d < 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] != 'X'){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            turn++;
            
        }
        // if(!findLever){
        //     result = -1;
        // }
        return -1;
    }
    public static int findExit(char[][] arr, Point lever){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[lever.x][lever.y] = true;
        queue.add(lever);
        int turn = 0; 
        boolean isExit = false;
        
        out:while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                Point cur = queue.poll();
                if(arr[cur.x][cur.y] == 'E'){
                    return turn;
                    // result += turn;
                    // isExit = true;
                    // break out;
                }
                for(int d = 0; d < 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] != 'X'){
                        queue.add(new Point(nx, ny));
                        
                        visited[nx][ny] = true;
                    }
                }
            }
            turn++;
        }
        // if(!isExit){
        //     result = -1;
        // }
        return -1;
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