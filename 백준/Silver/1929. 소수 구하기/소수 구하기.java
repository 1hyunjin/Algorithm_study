import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = isPrime(N);
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!arr[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean[] isPrime(int num) {
        boolean[] arr = new boolean[num+1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
        return arr;
    }
}