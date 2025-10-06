import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] arr = terms[i].split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        List<Integer> list = new ArrayList<>();
        String[] todays = today.split("\\.");
        int tyear = Integer.parseInt(todays[0]);
        int tmonth = Integer.parseInt(todays[1]);
        int tday = Integer.parseInt(todays[2]);
        int toSum = (tyear * 12 * 28) + (tmonth * 28) + tday;
        
        for(int i = 0; i < privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            String person = arr[1];
            String last = arr[0];
            
            String[] dates = last.split("\\.");
            int year = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]) + map.get(person);
            int day = Integer.parseInt(dates[2]);
            
            int total = (year * 12 * 28) + (month * 28) + day -1;
            
            if(total < toSum){
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}