import java.util.*;
import java.io.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            int c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                sb.append(c-'0');
            }
            else if(c == 'D' ||  c== 'S' || c == 'T'){
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                if(c == 'D') num = (int)Math.pow(num, 2);
                else if(c == 'T') num = (int)Math.pow(num, 3);
                
                list.add(String.valueOf(num));
            } 
            else if(c == '#'){
                list.add("#");
            } 
            else if(c == '*'){
                list.add("*");
            }
        }
        // System.out.println(list);
        Stack<Integer> stack = new Stack<>();
        for(String s : list){
            if(s.equals("#")){
                int score =stack.pop(); 
                stack.push(score * (-1));
            }
            else if(s.equals("*")){
                int first = stack.pop();
                if(!stack.isEmpty()){
                    int second = stack.pop();
                    stack.push(second*2);
                }
                stack.push(first*2);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
}