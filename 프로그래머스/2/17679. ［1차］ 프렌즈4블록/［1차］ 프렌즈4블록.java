import java.io.*;
import java.util.*;

class Solution {
    static Character[][] map;
    static Set<Integer> set;
    static int a, b;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        a = m;
        b = n;
        map = new Character[m][n];
        for(int i = 0; i < board.length; i++){
            String s = board[i];
            for(int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }
        set = new HashSet<>();
        while(true){
            // 2*2 있는지 찾아서 4개 다 같은거면 set에 넣기 
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    // 찾기 
                    if(i == m-1 || j == n-1){
                        continue;
                    }
                    if(map[i][j] == '.'){ // 빈 곳임을 체크 
                        continue; 
                    }
                    find(i, j);
                }
            }
            if(set.size() == 0){
                break;
            }
            answer += set.size(); 
            // 이제 터트리고 내려 
            bomb(); 
            fall(); 
        }
        
        return answer;
    }
    public static void fall(){
        for(int i = 0; i < b; i++){
            int floor = a-1;
            for(int j = floor; j >= 0; j--){
                if(map[j][i] != '.'){
                    char c = map[j][i];
                    map[j][i] = '.';
                    map[floor][i] = c;
                    floor--;
                }
            }
        }
        set.clear();
    }
    public static void bomb(){
        for(int num : set){
            int nx = num/b;
            int ny = num%b;
            
            map[nx][ny] = '.';
        }
    }
    public static void find(int x, int y){
        char c = map[x][y];
        List<Point> list = new ArrayList<>();
        int cnt = 0; 
        
        for(int i = x; i < x+2; i++){
            for(int j = y; j < y+2; j++){
                if(map[i][j] == c){
                    list.add(new Point(i, j));
                }
            }
        }
        if(list.size() == 4){
            for(Point p : list){
                int num = p.x * b + p.y;
                set.add(num);
            }
        }
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void print(){
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}