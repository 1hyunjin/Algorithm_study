import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int reminder = N%B;
            // 0~9는 숫자 그래도, 10~35는 A~Z로 변환
            if (reminder < 10) {
                sb.append(reminder);
            }
            else{
                sb.append((char) ('A' + (reminder - 10)));
            }
            N /= B;
        }
        System.out.println(sb.reverse());
    }
}