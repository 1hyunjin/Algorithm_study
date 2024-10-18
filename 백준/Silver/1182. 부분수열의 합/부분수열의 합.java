import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N , S;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        func(0,0);
        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    public static void func(int cur, int tot) {
        if (cur == N) {
            if (tot == S) {
                cnt++;
            }
            return;
        }
        func(cur+1, tot);   // 안더했을 때
        func(cur + 1, tot + arr[cur]);      // 더했을 때
    }
}