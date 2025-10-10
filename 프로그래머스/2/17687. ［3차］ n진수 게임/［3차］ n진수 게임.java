import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() < m*t){
            sb.append(Integer.toString(num++, n));
        }
        
        // System.out.println(sb.toString());
        StringBuilder result = new StringBuilder();
        int order = 0; 
        for(int i = 0; i < sb.length(); i++){
            if(order == p-1){
                result.append(sb.charAt(i));
                if(result.length() == t){
                    break;
                }
            }
            order = (order+1)%m;
        }
        answer = result.toString().toUpperCase();
        return answer;
    }
}