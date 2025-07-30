import java.io.*;
import java.util.*;

public class Main {
    static long INF = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long X = Long.parseLong(br.readLine());
        long result = pow(A, X);
        System.out.println(result);
    }

    public static long pow(long A, long X) {
        if (X == 0) {
            return 1;
        }
        if(X == 1){
            return A%INF;
        }
        long val = pow(A, X/2);
        val = ((val%INF)*(val%INF))%INF;

        if(X % 2 == 0){
            return val;
        }
        return ((val%INF)*(A%INF))%INF;
    }
}
