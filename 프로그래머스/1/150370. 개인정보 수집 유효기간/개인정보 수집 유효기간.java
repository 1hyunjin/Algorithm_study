import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] arr = terms[i].split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        // System.out.println(map);
        List<Integer> list = new ArrayList<>();
        String[] todays = today.split("\\.");
        int tyear = Integer.parseInt(todays[0]);
        int tmonth = Integer.parseInt(todays[1]);
        int tday = Integer.parseInt(todays[2]);
        int tsum = (tyear*12*28) + tmonth*28 + tday;
        // System.out.println(tsum);
        // System.out.println("=========");
        for(int i = 0; i < privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            String kinds = arr[1]; // 종류
            
            String[] days = arr[0].split("\\.");
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1]);
            int day = Integer.parseInt(days[2]);
            
            int kind = map.get(kinds);
            
            int sum = (year*28*12) + ((month+kind)*28) + day -1;
            // System.out.println(sum);
            if(sum < tsum){
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}