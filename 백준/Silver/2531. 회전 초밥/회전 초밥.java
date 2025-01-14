import java.util.*;
import java.io.*;

// 윈도우 슬라이딩 문제 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 0;
        int ans = 0;
        int cnt = 0;

        int[] eat = new int[d+1];

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            eat[arr[right]]++;
            if (eat[arr[right]] == 1) {
                cnt++;
            }
            right++;
        }

        ans = cnt;

        while (left != N) {
            // 왼쪽 초밥 제거
            eat[arr[left]]--;
            if (eat[arr[left]] == 0) { // 0이면 종류가 사라진거임
                cnt--;
            }
            left++;

            // 오른쪽 초밥 추가
            eat[arr[right]]++;
            if (eat[arr[right]] == 1) { // 새로운 종류가 추가된거
                cnt++;
            }
            right++;

            if (right == N) { // 오른쪽이 끝까지 같으면 0으로 변경 (순환)
                right = 0;
            }

            if (eat[c] == 0) {
                ans = Math.max(ans, cnt+1);
            } else {
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}