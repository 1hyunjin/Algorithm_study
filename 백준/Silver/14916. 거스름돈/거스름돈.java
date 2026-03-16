import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        while (true) {
            if (N % 5 == 0) {
                sum += N/5;
                break;
            }
            N -= 2;
            sum++;

            if (N < 0) {
                sum = -1;
                break;
            }
        }
        System.out.println(sum);
    }
}