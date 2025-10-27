import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String ps = br.readLine();
            int left =0 ;
            int right = 0;
            for (int i = 0; i < ps.length(); i++) {
                if (ps.charAt(i) == '(') {
                    left++;
                }
                else {
                    right++;
                }
            }
            if (left != right) {
                sb.append("NO").append("\n");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < ps.length(); i++) {
                if(ps.charAt(i) == '('){
                    stack.push(ps.charAt(i));
                }
                else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) {
                sb.append("NO").append("\n");
            }
            else{
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}