import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N >= 100) {
            if (N == 1000) {
                N = 999;
            }
            int cnt = 99;
            for (int i = 100; i <= N; i++) {
                int hun = i/100;
                int ten = (i/10)%10;
                int one = i%10;

                if (hun - ten == ten - one) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        else{
            System.out.println(N);
        }
    }
}