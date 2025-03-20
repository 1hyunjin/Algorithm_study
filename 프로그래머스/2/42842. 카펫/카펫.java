import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int c = 3; c < 5000; c++){
            for(int r = 3; r <= c; r++){
                int edge = 2*c + 2*r - 4; 
                
                if(edge == brown && (r*c)-edge == yellow){
                    answer[0] = c;
                    answer[1] = r;
                }
            }
        }
        return answer;
    }
}