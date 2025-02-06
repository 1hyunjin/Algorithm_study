import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+1];

            // 전처리
            for (int i = 1; i <= n; i++) {
                makeSet(i);
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (num == 0) {
                    union(a, b);
                }
                else {
                    if (find(a) != find(b)) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
    }

    public static void makeSet(int x) {
        arr[x] = x;  // 자신을 자신의 부모로 저장
    }

    // union : x와 y를 포함하는 두 집합을 통합하는 연산
    public static void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        else {
            arr[find(b)] = arr[find(a)];
        }
    }

    // find : x를 포함하는 집합을 찾는 연 산
    public static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        else {
            return arr[x] = find(arr[x]); // 경로 압축
            // 자신의 부모를 리턴 받은 우리 트리의 루트로 변경
        }
    }

}