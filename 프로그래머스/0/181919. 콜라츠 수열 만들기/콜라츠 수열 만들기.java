import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        while(true){
            list.add(n);
            if(n == 1){
                break;
            }
            if(n % 2 == 0){
                n/= 2;
            }
            else{
                n = 3*n+1;
            }
        }
        answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}