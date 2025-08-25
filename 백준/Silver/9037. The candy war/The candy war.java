import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 홀수인지 확인하기
            addCandy();
            // 순환 시작
            int turn = 0;
            while (true) {
                if (isSame()) {
                    sb.append(turn).append("\n");
                    break;
                }
                turn++;
                // 반절 오른쪽 사람한테 주기
                giveCandy();
                // 홀수인 사람 사탕 +1 해주기
                addCandy();
            }
        }
        System.out.println(sb);
    }

    public static void giveCandy() {
        int[] tmp = new int[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = arr[i] / 2;
            arr[i] = tmp[i];
        }
        for (int i = 0; i < N; i++) {
            arr[(i + 1) % N] += tmp[i];
        }
    }

    public static void addCandy() {
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 1) {
                arr[i] += 1; // 짝수로 만들어주기
            }
        }
    }

    public static boolean isSame() {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}