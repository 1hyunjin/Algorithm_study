import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("all")) {
                S = (1 << 21) - 1;  // 10000000000000000000-1 = 011111111111111111111
            }
            else if (op.equals("empty")) {
                S = 0;
            }
            else{
                int num = Integer.parseInt(st.nextToken());
                if (op.equals("add")) {
                    S |= (1 << num);
                }
                else if (op.equals("remove")) {
                    S &= ~(1 << num);
                }
                else if (op.equals("check")) {
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append('\n');
                }
                else{
                    S ^= (1 << num);
                }
            }
        }
        System.out.println(sb.toString());
    }
}