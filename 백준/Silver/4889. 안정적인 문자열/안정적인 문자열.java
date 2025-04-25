import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 1;
        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '-') {
                break;
            }
            char[] arr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c == '{') {
                    stack.add(c);
                }else { // c == '}'
                    if (stack.isEmpty()) {
                        cnt++;
                        stack.add('{');
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                cnt += stack.size()/2;
            }
            System.out.println(TC + ". " + cnt);
            TC++;
        }
    }
}