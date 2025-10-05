import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static  int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 크기가 1이면 뒤에 나올 숫자는 여러개
        if (arr.length == 1) {
            System.out.println("A");
        }
        // 배열 크기가 2이고 둘 다 똑같은 숫자면 다음 나올 숫자도 똑같은 숫자
        else if (arr.length == 2 && arr[0] == arr[1]) {
            System.out.println(arr[0]);
        }
        // 배열 크기가 2이고 다른 숫자면? 다음 나올 숫자 여러개 (a랑 b 는 하나가지고 구하지 못하니까)
        else if (arr.length == 2 && arr[0] != arr[1]) {
            System.out.println("A");
        }
        else {
            int a;
            int b;
            boolean isB = false;

            if (arr[1] == arr[0]) {
                a = 1;
                b = 0;
            } else {
                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - (arr[0] * a);
            }
//            System.out.println("a : " + a + " , " + " b : " + b);
            for (int i = 1; i < N; i++) {
                if (arr[i] != arr[i - 1] * a + b) {
                    isB = true;
                    break;
                }
            }
            if (isB) {
                System.out.println("B");
            } else {
                System.out.println(arr[N-1]*a + b);
            }
        }

    }
}