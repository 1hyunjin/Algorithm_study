import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int len = speeds.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int na = (100-progresses[i]);
            if(na%speeds[i] > 0){
                na = (na/speeds[i]) + 1;
            }
            else{
                na = (na/speeds[i]);
            }
            if(stack.isEmpty()){
                stack.push(na);
                max = na;
            }
            else{
                if(max < na){
                    list.add(stack.size());
                    stack.clear();
                    stack.push(na);
                    max = na;
                }
                else{
                    stack.push(na);
                }
            }
        }
        if(!stack.isEmpty()){
            list.add(stack.size());
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}