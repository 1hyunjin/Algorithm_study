import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = 0;
        perm(0);
        System.out.println(cnt);
    }
    public static void perm(int idx){
        if(idx == N){
            boolean isBeautiful = true;
            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for(int i = 1; i < N; i++){
                int peek = stack.peek();
                if(peek != arr[i]){
                    if(stack.size() % peek == 0){
                        stack.clear();
                        stack.push(arr[i]);
                    }
                    else{
                        isBeautiful = false;
                        break;
                    }
                }
                else{
                    stack.push(arr[i]);
                }
            }
            if(!stack.isEmpty()){
                if(stack.size() % stack.peek() != 0){
                    isBeautiful = false;
                }
            }
            if(isBeautiful){
                cnt++;
            }
            return;
        }
        for(int i = 1; i <= 4; i++){
            arr[idx] = i;
            perm(idx+1);
        }
    }
}