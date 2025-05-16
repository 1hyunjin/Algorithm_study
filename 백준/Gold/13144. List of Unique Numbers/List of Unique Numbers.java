import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] num = new int[100001];

        int s =0 ;
        int e = 0;
        long cnt = 0;

        while (e < N) {
            if (num[arr[e]] == 0) {
                num[arr[e]]++;
                e++;
                cnt += e-s;
            }
            else{
                num[arr[s]]--;
                s++;
            }
        }
        System.out.println(cnt);
    }
}