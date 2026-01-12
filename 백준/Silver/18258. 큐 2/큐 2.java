import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int head = 0;
        int tail = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                arr[tail++] = num;
            } else if (str.equals("pop")) {
                if (head == tail) {
                    sb.append("-1\n");
                } else {
                    sb.append(arr[head]).append('\n');
                    head++;
                }
            } else if (str.equals("size")) {
                sb.append(tail - head).append('\n');
            } else if (str.equals("empty")) {
                if (tail - head == 0) {
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            } else if (str.equals("front")) {
                if (tail - head == 0) {
                    sb.append("-1\n");
                } else {
                    sb.append(arr[head]).append('\n');
                }
            } else if (str.equals("back")) {
                if (tail - head == 0) {
                    sb.append("-1\n");
                } else {
                    sb.append(arr[tail - 1]).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}