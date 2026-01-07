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
            boolean isBalance = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if(!stack.isEmpty()){
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            stack.push(c);
                        }
                    }
                    else{
                        isBalance = false;
                        break;
                    }
                } else if (c == '[') {
                    stack.push(c);
                } else if (c == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else{
                            stack.push(c);
                        }
                    }
                    else{
                        isBalance = false;
                        break;
                    }
                }
            }
            if (!isBalance || (isBalance && !stack.isEmpty())) {
                sb.append("no").append("\n");
            }
            else {
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}