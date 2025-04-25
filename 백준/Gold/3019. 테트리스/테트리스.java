import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tmp = new int[C];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            tmp[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, tmp[i]);
        }

        int[] arr = new int[C];
        for (int i = 0; i < C; i++) {
            arr[i] = tmp[i] - min;
        }
//        System.out.println(Arrays.toString(arr));
        int cnt = 0;
        if (P == 1) {
            cnt = C;
            for (int i = 0; i <= C - 4; i++) {
                int mitmeon = 1;
                for (int j = i + 1; j < i + 4; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 4) {
                    cnt++;
                }
            }
        }
        if (P == 2) {
            for (int i = 0; i <= C - 2; i++) {
                int mitmeon = 1;
                for (int j = i + 1; j < i + 2; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 2) {
                    cnt++;
                }
            }
        }
        if (P == 3) {
            for (int i = 0; i <= C - 3; i++) {
                if (arr[i] == arr[i + 1] && arr[i + 2] - arr[i + 1] == 1) {
                    cnt++;
                }
            }
            for (int i = 0; i < C - 1; i++) {
                if (arr[i] - arr[i + 1] == 1) {
                    cnt++;
                }
            }
        }
        if (P == 4) {
            for (int i = 0; i <= C - 3; i++) {
                if (arr[i] - arr[i+1] == 1 && arr[i+1] == arr[i+2]) {
                    cnt++;
                }
            }
            for (int i = 0; i < C - 1; i++) {
                if (arr[i + 1] - arr[i] == 1) {
                    cnt++;
                }
            }
        }
        if (P == 5) {
            for (int i = 0; i <= C - 3; i++) {
                int mitmeon = 1;
                for (int j = i+1; j < i+3; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 3) {
                    cnt++;
                }
            }
            for (int i = 0; i < C - 1; i++) {
                if (arr[i] - arr[i + 1] == 1) {
                    cnt++;
                }
                if (arr[i + 1] - arr[i] == 1) {
                    cnt++;
                }
            }
            for (int i = 1; i < C - 1; i++) {
                if (arr[i - 1] - arr[i] == 1 && arr[i + 1] - arr[i] == 1) {
                    cnt++;
                }
            }
        }
        if (P == 6) {
            for (int i = 0; i <= C - 3; i++) {
                int mitmeon = 1;
                for (int j = i+1; j < i+3; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 3) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 2; i++) {
                int mitmeon = 1;
                for (int j = i + 1; j < i + 2; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 2) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 3; i++) {
                if (arr[i+1] == arr[i+2] && arr[i+1] - arr[i] == 1) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 2; i++) {
                if (arr[i] - arr[i + 1] == 2) {
                    cnt++;
                }
            }
        }
        if (P == 7) {
            for (int i = 0; i <= C - 3; i++) {
                int mitmeon = 1;
                for (int j = i+1; j < i+3; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 3) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 2; i++) {
                int mitmeon = 1;
                for (int j = i + 1; j < i + 2; j++) {
                    if (arr[i] == arr[j]) {
                        mitmeon++;
                    }
                }
                if (mitmeon == 2) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 3; i++) {
                if (arr[i] == arr[i+1] && arr[i+1] - arr[i+2] == 1) {
                    cnt++;
                }
            }
            for (int i = 0; i <= C - 2; i++) {
                if (arr[i+1] - arr[i] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}