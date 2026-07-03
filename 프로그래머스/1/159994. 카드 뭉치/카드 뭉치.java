import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int cur = 0;
        int idx1 = 0;
        int idx2 = 0;
        boolean isGoal = true;
        Queue<String> queue1 = new ArrayDeque<>();
        for(int i = 0; i < cards1.length; i++){
            queue1.offer(cards1[i]);
        }
        Queue<String> queue2 = new ArrayDeque<>();
        for(int i = 0; i < cards2.length; i++){
            queue2.offer(cards2[i]);
        }
        for(int i = 0; i < goal.length; i++){
            String target = goal[i];
            // System.out.println(queue1);
            // System.out.println(queue2);
            if(queue1.size() > 0 && target.equals(queue1.peek())){
                // System.out.println("큐1에서 빼냄");
                queue1.poll();
            }
            else if(queue2.size() > 0 && target.equals(queue2.peek())){
                // System.out.println("큐2에서 빼냄");
                queue2.poll();
            }
            else{
                isGoal = false;
                break;
            }
        }
        if(isGoal){
            return "Yes";
        }
        else{
            return "No";
        }
    }
}