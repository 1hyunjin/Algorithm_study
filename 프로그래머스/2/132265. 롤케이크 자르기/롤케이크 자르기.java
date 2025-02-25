import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int len = topping.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < len; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        // System.out.println(map);
        
        HashMap<Integer, Integer> sis = new HashMap<>();
        
        for(int i = len-1; i >= 0; i--){
            
            if(map.containsKey(topping[i])){
                int cnt = map.get(topping[i]);
                if(cnt > 1){
                    map.put(topping[i], cnt-1);
                }
                else if (cnt == 1) {  
                    map.remove(topping[i]);
                }
                sis.put(topping[i], sis.getOrDefault(topping[i], 0)+1);
                // System.out.println("map : " + map);
                // System.out.println("sis : " + sis);
            }    
            if(map.size() == sis.size()){
                answer++;
            }
        }
        
        return answer;
    }
}