import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (left == N && right == M) {
                break;
            }
            if (left == N && right < M) {
                sb.append(arr2[right]).append(" ");
                right++;
            }
            else if (right == M && left < N) {
                sb.append(arr1[left]).append(" ");
                left++;
            }
            else if (arr1[left] <= arr2[right]) {
                sb.append(arr1[left]).append(" ");
                left++;
            }
            else if (arr1[left] >= arr2[right]) {
                sb.append(arr2[right]).append(" ");
                right++;
            }
        }
        System.out.println(sb);
    }
}
