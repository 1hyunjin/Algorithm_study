import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = factorial(N);
        System.out.println(result);
    }

    public static int factorial(int N) {
        if(N <= 1 )return 1;
        return N * factorial(N-1);
    }
}