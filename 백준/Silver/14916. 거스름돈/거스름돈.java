import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            if (N % 5 == 0) {
                cnt+=N/5;
                break;
            }
            N-=2;
            cnt++;

            if (N < 0) {
                cnt=-1;
                break;
            }
        }
        System.out.println(cnt);
    }
}