import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());

        int[] arr = new int[A];
        int[] bArr = new int[B];

        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);

        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bArr[i] = Integer.parseInt(str.nextToken());
        }

        int cnt = A;
        boolean[] isInclude = new boolean[A];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < B; i++) {
            int st = 0;
            int en = A-1;

            while (st <= en) {
                int mid = (st + en) / 2;

                if (arr[mid] < bArr[i]) {
                    st = mid + 1;
                } else if (arr[mid] > bArr[i]) {
                    en = mid - 1;
                } else {
                    cnt--;
                    isInclude[mid] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < A; i++) {
            if (!isInclude[i]) {
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(cnt);
        if (cnt > 0) {
            System.out.println(sb);
        }
    }
}