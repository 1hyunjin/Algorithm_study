import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
            else{
                if(c == '('){
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty()) {
                        stack.pop(); // '(' 만났을 때 제거
                    }
                }
                else {
                    // + - * /
                    while (!stack.isEmpty() && order(stack.peek()) >= order(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    public static int order(Character c) {
        if(c == '(')return 0;
        if(c == '+' || c == '-') return 1;
        if(c == '*' || c == '/') return 2;
        else return -1;
    }
}