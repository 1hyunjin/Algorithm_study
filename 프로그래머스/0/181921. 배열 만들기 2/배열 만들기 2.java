import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        while(!q.isEmpty()){
            int num = q.poll();
            if(num > r){
                continue;
            }
            if(num >= l){
                list.add(num);
            }
            
            q.add(num*10);
            q.add(num*10 + 5);
        }
        if(list.size() == 0){
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}