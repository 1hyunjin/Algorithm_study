import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(stack.size() == 0){
                stack.push(s.charAt(i));
            }
            else {
                if(s.charAt(i) != stack.peek()){
                    stack.push(s.charAt(i));
                }
                else if(s.charAt(i) == stack.peek()){
                    stack.pop();
                }
            }
        }
        if(stack.size() == 0){
            return 1;
        }
        else {
            return 0;
        }
    }
}