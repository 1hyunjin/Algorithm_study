import java.io.*;
import java.util.*;

public class Main {
    static long INF = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            if (s.charAt(0) == ')') {
                sb.append("NO").append("\n");
                continue;
            }
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                }else{
                    right++;
                }
            }
            if (left != right) {
                sb.append("NO").append("\n");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else{
                        stack.push(s.charAt(i));
                    }
                }else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
                continue;
            }
            else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
