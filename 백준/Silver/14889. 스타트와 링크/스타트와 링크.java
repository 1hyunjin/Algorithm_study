import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] players;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		players = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i < N; i++) {
			players[i] = i;
		}
		
		comb(0,0);
		System.out.println(min);
	}
	static int min = Integer.MAX_VALUE;
	public static void comb(int idx, int cnt) {
		
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(isSelected));
			int start = 0;
			int link = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(isSelected[i] == true && isSelected[j] == true) {
						start+= map[i][j];
					}
					else if(!isSelected[i] && !isSelected[j]) {
						link+= map[i][j];
					}
				}
			}
//			System.out.println(start);
//			System.out.println(link);
			
			int result = Math.abs(start - link);
			min = Math.min(result, min);
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		isSelected[idx] = true;
		comb(idx+1, cnt+1);
		isSelected[idx] = false;
		comb(idx+1, cnt);
	}


}