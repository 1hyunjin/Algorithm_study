import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        int n = my_string.length();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(my_string.substring(i, n));
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}