import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] result = isPrime(N);
        for (int i = M; i <= N; i++) {
            if (!result[i]) {
                System.out.println(i);
            }
        }
    }

    public static boolean[] isPrime(int N){
        boolean[] prime = new boolean[N+1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        return prime;
    }
}