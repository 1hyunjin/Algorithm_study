import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int len = words.length;
        int totalTurn = len/n;
        
        int start = 1;
        int turn = 1; 
        boolean isEnd = true;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++){
            // System.out.println(map);
            if(start == n+1){
                start = 1;
                turn++;
            }
            
            if(words[i].length() == 1){
                answer[0] = start;
                answer[1] = turn;
                isEnd = true;
                break;
            }
            
            if(i > 0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                // System.out.println("여기서 틀림!" + words[i] + " , " + start + " , 차례 : " + turn);
                answer[0] = start;
                answer[1] = turn;
                isEnd = true;
                break;
            }
            
            if(!map.containsKey(words[i])){
                map.put(words[i], start);
                start++;
            }
            
            else {
                // System.out.println("여기서 틀림!" + words[i] + " , " + start + " , 차례 : " + turn);
                answer[0] = start;
                answer[1] = turn;
                isEnd = true;
                break;
            }
        }
        // if(!isEnd){
        //     answer[0] = 0;
        //     answer[1] = 0;
        // }
        return answer;
    }
}