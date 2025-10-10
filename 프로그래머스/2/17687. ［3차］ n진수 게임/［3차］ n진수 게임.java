import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(sb.length() < m*t){
            // System.out.println(change(num, n));
            sb.append(change(num, n));
            num++;
        }
        
        // System.out.println(sb.toString());
        StringBuilder result = new StringBuilder();
        int order = 0; // 순서 (0~m-1)
        for(int i = 0; i < sb.length(); i++){
            if(order == p-1){
                result.append(sb.charAt(i));
                if(result.length() == t){
                    break;
                }
            }
            order = (order+1)%m;
        }
        answer = result.toString();
        return answer;
    }
    public static String change(int num, int n){
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int x = num;
        while(x > 0){
            int r = x%n;
            if(r < 10){
                sb.append(r);
            }
            else{
                sb.append((char)('A'+(r-10)));
            }
            x/= n;
        }
        
        return sb.reverse().toString();
    }
}