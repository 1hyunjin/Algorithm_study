import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.replaceAll("\\{\\{", "").replaceAll("\\}\\}", "")
                .replaceAll("\\},\\{", "-");

        String[] arr = s.split("-");
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        List<Integer> list = new ArrayList<>();
        
        for(String str : arr){
            String[] tmp= str.split(",");
            for(String e : tmp){
                int num = Integer.parseInt(e);
                if(list.contains(num))continue;
                list.add(num);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}