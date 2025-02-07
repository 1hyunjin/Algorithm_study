import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] num, op;
	static int max, min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new int[N];
		op = new int[4]; // +, -, * , /

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(num[0], 1); // num[0] = 5, idx = 1

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int sum, int idx) {
		// 숫자 다 썼으면?
		if (idx == N) {
//			System.out.println("sum = " + sum);
			// 최대인지 최소인지 확인해주자.
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}

		// +
		if (op[0] > 0) {
			op[0]--; // 연산자 회수 줄이고
//			System.out.println(sum + " + " + num[idx] + "= " + (sum+num[idx]));
			dfs(sum + num[idx], idx + 1);
			// return하면 원상복구
			op[0]++;
		}
		// -
		if (op[1] > 0) {
			op[1]--;
//			System.out.println(sum + " - " + num[idx] + "= " + (sum-num[idx]));
			dfs(sum - num[idx], idx + 1);
			op[1]++;
		}
		// *
		if (op[2] > 0) {
			op[2]--;
//			System.out.println(sum + " * " + num[idx] + "= " + (sum*num[idx]));
			dfs(sum * num[idx], idx + 1);
			op[2]++;
		}
		// /
		if (op[3] > 0) {
			op[3]--;
//			System.out.println(sum + " / " + num[idx] + "= " + (sum/num[idx]));
			dfs(sum / num[idx], idx + 1);
			op[3]++;
		}
	}
}