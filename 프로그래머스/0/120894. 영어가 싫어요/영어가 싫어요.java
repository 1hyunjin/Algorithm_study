import java.util.*;
class Solution {
    public long solution(String numbers) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String s = "";
        while(idx < numbers.length()){
            s += numbers.charAt(idx);
            if(s.equals("one")){
                sb.append(1); 
                s = "";
            } 
            else if(s.equals("two")) {
                sb.append(2);
                s = "";
            }
            else if(s.equals("three")) {
                sb.append(3);
                s = "";
            }
            else if(s.equals("four")) {
                sb.append(4);
                s = "";
            }
            else if(s.equals("five")) {
                sb.append(5);
                s = "";
            }
            else if(s.equals("six")) {
                sb.append(6);
                s = "";
            }
            else if(s.equals("seven")) {
                sb.append(7);
                s = "";
            }
            else if(s.equals("eight")) {
                sb.append(8);
                s = "";
            }
            else if(s.equals("nine")) {
                sb.append(9);
                s = "";
            }
            else if(s.equals("zero")){
                sb.append(0);
                s="";
            }
            idx++;
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}