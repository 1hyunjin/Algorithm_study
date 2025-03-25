import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            int[] arr = new int[N+1];
            int zeroCnt = 0;
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0) {
                    zeroCnt++;
                }
            }

            Arrays.sort(arr);

            if(zeroCnt > 0){
                int idx = zeroCnt+1;
                int i = 1;
                for(int k = idx; k < idx+2; k++){
                    arr[i] = arr[k];
                    arr[k] = 0;
                    i++;
                }
            }

            int smaller = N/2;
            int bigger = N - (N/2);

            int biggerSum = 0;
            int smallerSum = 0;
            // bigger 부터
            for (int i = 1; i <= N; i++) {
                if (i % 2 != 0) {
                    if (i == 1 && arr[i] == 0) {
                        biggerSum += arr[i+2] * Math.pow(10, bigger-1);
                        bigger = bigger-2;
                        i = 4;
                    }
                    else {
                        biggerSum += arr[i] * Math.pow(10, bigger-1);
                        bigger--;
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    if (i == 2 && arr[i] == 0) {
                        smallerSum += arr[i+2] * Math.pow(10, smaller-1);
                        smaller = smaller-2;
                        i = 5;
                    }
                    else {
                        smallerSum += arr[i] * Math.pow(10, smaller-1);
                        smaller--;
                    }
                }
            }
            System.out.println(biggerSum+smallerSum);
        }
    }
}
