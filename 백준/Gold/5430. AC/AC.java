import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc = 0; tc < TC; tc++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> deque = new ArrayDeque<>();

            for(int i = 0; i < n; i++){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            func(deque, str);
        }
        System.out.println(sb);
    }
    public static void func(Deque<Integer> deque, String str){
        boolean isReversed = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'R'){
                isReversed = !isReversed;
            }
            else if(str.charAt(i) == 'D'){
                if(isReversed){
                    if(deque.pollLast() == null){
                        sb.append("error").append("\n");
                        return;
                    }
                }
                else {
                    if (deque.pollFirst() == null) {
                        sb.append("error").append("\n");
                        return;
                    }
                }
            }
        }
        sb.append("[");
        while (deque.size() > 1) {
            if(isReversed){
                sb.append(deque.pollLast()).append(",");
            }
            else {
                sb.append(deque.pollFirst()).append(",");
            }
        }
        if (deque.isEmpty()) {
            sb.append("]").append("\n");
        }
        else {
            sb.append(deque.poll()).append("]").append("\n");
        }
    }
}