import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (str.length() % 2 != 0) {
                sb.append("NO").append("\n");
                continue;
            }
            int left = 0;
            int right = 0;
            Stack<Character> stack = new Stack<>();
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) == '(') {
                    left++;
                } else {
                    right++;
                }
                stack.push(str.charAt(j));
            }
            if (left != right) {
                sb.append("NO").append("\n");
                continue;
            }
            left = 0;
            right = 0;
            boolean isMatch = true;
            while (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '(') {
                    if (stack.peek() == ')') {
                        right++;
                        stack.pop();
                    }
                    left++;
                } else {
                    right++;
                    if (left < right) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if (!isMatch) {
                sb.append("NO").append("\n");
            }
            else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}