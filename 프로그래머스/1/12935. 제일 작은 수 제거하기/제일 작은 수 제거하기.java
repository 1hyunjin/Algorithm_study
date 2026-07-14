import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        if(arr.length == 1){
            return answer;
        }
        int minIdx = 0;
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(i != minIdx){
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}