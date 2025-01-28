import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int sum = 0;
        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            sum+= n;

            arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            sb.append(arr[end] - arr[start - 1]).append('\n');
        }
        String result = sb.toString();
        System.out.println(result);

    }
}