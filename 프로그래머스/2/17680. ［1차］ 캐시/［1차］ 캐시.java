import java.util.*;
import java.io.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            if(list.size() == 0 ){
                list.add(city);
                map.put(city, 1);
                answer += 5;
            }
            else if(list.size() < cacheSize){
                if(map.containsKey(city)){
                    // 위치 마지막으로 옮겨
                    int idx = list.indexOf(city);
                    list.remove(idx);
                    list.add(city);
                    answer += 1;
                }
                else{
                    map.put(city, 1);
                    list.add(city);
                    answer+=5;
                }
            }
            else if(list.size() == cacheSize){
               if(map.containsKey(city)){
                   int idx = list.indexOf(city);
                   list.remove(idx);
                   list.add(city);
                   answer+=1;
               }
                else{
                    map.remove(list.get(0)); // 처음꺼 삭제
                    list.remove(0);
                    list.add(city);
                   map.put(city, 1);
                    answer+=5;
                }
            }
            
            // for(int j = 0; j < list.size(); j++){
            //     System.out.print(list.get(j) + " ");
            // }
            // System.out.println();
            // System.out.println("실행 시간 : " + answer);
        }
        
        return answer;
    }
}