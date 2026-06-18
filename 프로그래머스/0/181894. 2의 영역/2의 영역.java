import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else if(min == max){
            answer = new int[1];
            answer[0] = arr[min];
            return answer;
        }
        else if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE){
            answer = new int[max-min+1];
            for(int j = min; j <= max; j++){
                answer[j-min] = arr[j];
            }
        }
        return answer;
    }
}