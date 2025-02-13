import java.io.*;
import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int c = 1;
        int sum = 10000000;
        String str = String.valueOf(storey);
        int idx = str.length() - 1;
        
        Queue<Info> queue = new ArrayDeque<>();
        
        queue.add(new Info(storey, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int s = 0; s < size; s++){
                
                Info cur = queue.poll();
                // System.out.println(cur);
                
                if(cur.floor == 0){
                    sum = Math.min(sum, cur.stone);
                    continue;
                }
                
                // String str1 = String.valueOf(cur.floor);
                // int num = Integer.parseInt(String.valueOf(str1.charAt(idx)));
                
                // System.out.println(num);
                
                int num = cur.floor % 10;
                int nextFloor = cur.floor / 10;
                
                if(num < 5){
                    // queue.add(new Info(cur.floor - (num*c), cur.stone + num));
                    queue.add(new Info(nextFloor, cur.stone + num));
                }
                else if(num == 5){
                    // queue.add(new Info(cur.floor + (num*c), cur.stone + 5));
                    // queue.add(new Info(cur.floor - (num*c), cur.stone + 5));
                    queue.add(new Info(nextFloor + 1, cur.stone + 5));
                    queue.add(new Info(nextFloor, cur.stone + 5));
                }
                else {
                    // queue.add(new Info(cur.floor + ((10 - num)*c), cur.stone + (10-num)));
                    queue.add(new Info(nextFloor + 1, cur.stone + (10-num)));
                }
            }
        }
        answer = sum;
        return answer;
    }
    
    public static class Info{
        int floor;
        int stone;
        
        public Info(int floor, int stone){
            this.floor = floor;
            this.stone = stone;
        }
        @Override
        public String toString(){
            return "Info : " + floor + ", " + stone;
        }
    }
}