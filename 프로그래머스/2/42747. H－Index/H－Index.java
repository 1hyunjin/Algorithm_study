import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int[] arr = new int[citations.length];
        for(int i = 0; i < citations.length; i++){
            arr[i] = citations[citations.length-1 - i];
        }
        // System.out.println(Arrays.toString(arr));
        
        for(int i = 0; i < citations.length; i++){
            if(arr[i] <= i){
                answer = i;
                return answer;
            }
        }
        return citations.length;
    }
}