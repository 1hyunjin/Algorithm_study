import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        int min = s.length();
        
        for(int i = 1; i < len; i++){
            
            // cut(s, i, len);
            min = Math.min(min, cut(s, i, len));
        }
        answer = min;
        return answer;
    }
    public int cut(String s, int n, int len){
        
        int cnt = 0;
        String str = s.substring(0,n);
        
        String cur = "";
        String result = "";
        
        for(int i = 0; i < len; i=i+n){
            // System.out.println("str : " + str);
            
            if(i+n > len){
                cur = s.substring(i, len);
            }
            else {
                cur = s.substring(i, i+n);    
            }
            
            // System.out.print(cur + " ");
            
            if(str.equals(cur)){
                cnt++;
            }
            else {
                // 다른게 나왔다면
                if(cnt > 1){
                    result+= cnt+str;
                }
                else {
                    result += str;
                }
                cnt = 1;
                str = cur;
            }
            // System.out.println("result :" + result);
        }
        if(cnt > 1){
            result += cnt + str;
        }
        else {
            result += str;
        }
        // System.out.println("result :" + result);    
        // System.out.println();
        return result.length();
    }
}