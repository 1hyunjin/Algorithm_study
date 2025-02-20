import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int len = tangerine.length;
        
        Point[] point = new Point[10000001];
        
        Arrays.fill(point, new Point(0,0));
        
        for(int i = 0; i < len; i++){
            int n = tangerine[i];
            if(point[n].cnt == 0){
                point[n] = new Point(n, 1);
            }
            else {
                point[n] = new Point(n, point[n].cnt+1);
            }
        }
        
        Arrays.sort(point);
        
        int total = 0; 
        
        for(int i = 0; i < point.length; i++){
            
            k -= point[i].cnt;
            total++;
            
            if(k <= 0){
                answer = total;
                break;
            }
        }
        return answer;
    }
    
    public static class Point implements Comparable<Point>{
        int num;
        int cnt;
        
        public Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Point o){
            return o.cnt - this.cnt;
        }
    }
}