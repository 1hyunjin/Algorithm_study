import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 0; i <= 6; i++) {
            stacks[i] = new Stack<>();
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(stacks[num].isEmpty() || stacks[num].peek() < p){
                stacks[num].push(p);
                cnt++;
            }
            else if (stacks[num].peek() > p){
                while (true) {
                    if (stacks[num].isEmpty() || stacks[num].peek() < p) {
                        stacks[num].push(p);
                        cnt++;
                        break;
                    } else if (stacks[num].peek() == p) {
                        break;
                    }
                    stacks[num].pop();
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}