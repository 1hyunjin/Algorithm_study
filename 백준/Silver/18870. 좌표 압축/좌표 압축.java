import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }

        int[] sortArr = new int[set.size()];

        int idx = 0;

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            sortArr[idx++] = iter.next();
        }

        Arrays.sort(sortArr);

        StringBuilder sb = new StringBuilder();

        // 이분 탐색
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int start = 0;
            int end = sortArr.length -1 ;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (num < sortArr[mid]) {
                    end = mid -1;
                } else if (num > sortArr[mid]) {
                    start = mid + 1;
                } else {
                    sb.append(mid).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}