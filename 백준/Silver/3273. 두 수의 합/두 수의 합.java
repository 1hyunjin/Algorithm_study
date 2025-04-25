import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // O(N^2)알고리즘 -> O(N) 으로도 풀 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int[] arr1 = new int[x];
        int result = 0;

        //나와 합이 x가 되는 원소를 매 순간마다 O(1)에 찾고 이 행위를 N번 반복하기 때문에 총 시간복잡도는 O(N)이 된다.
        for (int i = 0; i < N; i++) {
            if (x - arr[i] > 0) {
                arr1[arr[i]] = 1;
                // n개의 서로 다른 양의 정수이기 때문에
                if (arr[i] != x-arr[i] && arr1[x - arr[i]] == 1) {
//                    System.out.println(arr[i] + " , " + (x-arr[i]));
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}