import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch(op) {
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop" :
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    }
                    else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "top" :
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    }
                    else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}