import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] result;

	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		sb = new StringBuilder();
		comb(0);
		System.out.println(sb.toString());
	}
	static StringBuilder sb;
	
	public static void comb(int cnt) {
		if(cnt == M) {
			for(int i =0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[cnt] = i+1;
			comb(cnt+1);
		}
	}
}