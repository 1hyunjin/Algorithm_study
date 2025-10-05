import java.util.*;
import java.io.*; 

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length()-1; i++){
            String sub = str1.substring(i, i+2);
            if(Character.isAlphabetic(sub.charAt(0)) && Character.isAlphabetic(sub.charAt(1))){
                sub = sub.toUpperCase();
                map1.put(sub, map1.getOrDefault(sub, 0) + 1);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            String sub = str2.substring(i, i+2);
            if(Character.isAlphabetic(sub.charAt(0)) && Character.isAlphabetic(sub.charAt(1))){
                sub = sub.toUpperCase();
                map2.put(sub, map2.getOrDefault(sub, 0) + 1);
            }
        }
        if(map1.size() == 0 && map2.size() == 0){
            return 65536; 
        }
        Map<String, Integer> gyo = new HashMap<>();
        // 교집합
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key), map2.get(key));
                gyo.put(key, min);
            }
        }
        Map<String, Integer> hap = new HashMap<>();
        // 합집합
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int max = Math.max(map1.get(key), map2.get(key));
                hap.put(key, max);
            }
            else{
                hap.put(key, map1.get(key));
            }
        }
        for(String key : map2.keySet()){
            if(!hap.containsKey(key)){
                hap.put(key, map2.get(key));
            }
        }
        int gyoSum = 0;
        int hapSum = 0; 
        
        for(String key : gyo.keySet()){
            gyoSum += gyo.get(key);
        }
        for(String key : hap.keySet()){
            hapSum += hap.get(key);
        }
        double result = (double) gyoSum / hapSum;
        answer = (int)(result * 65536);
        return answer;
    }
}