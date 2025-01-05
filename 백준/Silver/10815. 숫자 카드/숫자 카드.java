import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        str = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        int K = Integer.parseInt(br.readLine());

        int[] sang = new int[K];

        str = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            sang[i] = Integer.parseInt(str.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int st = 0;
            int en = N-1;
            boolean isExit = false;
            while (st <= en) {
                int mid = (st + en) / 2;
                if (arr[mid] < sang[i]) {
                    st = mid + 1;
                } else if (arr[mid] > sang[i]) {
                    en = mid - 1;
                }
                else {
                    sb.append("1").append(" ");
                    isExit = true;
                    break;
                }
            }
            if (!isExit) {
                sb.append("0").append(" ");
            }
        }
        System.out.println(sb);
    }
}