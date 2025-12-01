import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            set.add(A);
            arr[i] = A;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            if (!set.contains(D)) {
                sb.append("-1").append("\n");
                continue;
            }
            long s = 0;
            long e = N-1;
            while (s <= e) {
                long mid = (s+e)/2;
                if (arr[(int) mid] < D) {
                    s = mid+1;
                } else if (arr[(int) mid] > D) {
                    e = mid-1;
                } else if (arr[(int) mid] == D) {
                    if(mid == 0){
                        sb.append(mid).append("\n");
                        break;
                    }
                    else if (mid-1 >= 0 && arr[(int) mid - 1] != D) {
                        sb.append(mid).append("\n");
                        break;
                    }
                    else{
                        e = mid-1;
                    }
                }
            };
        }
        System.out.println(sb.toString());
    }
}