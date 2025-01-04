import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(num));
        }
    }

    public static int binarySearch(int target) {
        int start = 0;
        int end = N-1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}