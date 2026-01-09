import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '('){
                    stack.push('(');
                }
                else if (c == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            stack.push(')');
                        }
                    }
                    else{
                        isVPS = false;
                        break;
                    }
                }
                else if (c == '[') {
                    stack.push('[');
                }
                else if (c == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else{
                            stack.push(']');
                        }
                    }
                    else{
                        isVPS = false;
                        break;
                    }
                }
            }
            if (isVPS && stack.isEmpty()) {
                sb.append("yes").append('\n');
            }
            else{
                sb.append("no").append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}