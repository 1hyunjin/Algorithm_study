import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int xCnt = 0;
        int nCnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(xCnt == 0 && nCnt == 0){
                x = s.charAt(i);
                // System.out.println("x : " + x);
            }
            if(s.charAt(i) == x){
                xCnt++;
            }
            else{
                nCnt++;
            }
            // System.out.println("xCnt : " + xCnt + " , nCnt : " + nCnt);
            if(xCnt == nCnt){
                answer++;
                xCnt = 0;
                nCnt = 0;
            }
        }
        if(xCnt != 0 || nCnt != 0){
            answer++;
        }
        
        return answer;
    }
}