import java.util.Arrays;
class Solution {
    public int solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(i);
        }
        System.out.println(fibonacci(n));
        return fibonacci(n);
    }
    public static final int[] mem = new int[100001];

    public static int fibonacci(int n) {
        if (mem[n] != -1) {
            return mem[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return mem[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
    }
}