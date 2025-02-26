import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static List<CCTV> cctvList;
	static int[] result;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctvList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 0(빈칸)이 아니고 6(벽) 이 아니면 cctv 들이니까 모아두자.
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		// end input
		result = new int[cctvList.size()];
		min = Integer.MAX_VALUE;
		subset(0);
		
		System.out.println(min);
	}

	public static void subset(int idx) {

		if (idx == cctvList.size()) {
//			System.out.println(Arrays.toString(result));
			// 이제 상태대로 돌려야하는뎁
			checkStatus(result);
			return;
		}

		for (int s = 1; s <= 4; s++) {
			// cctv 2번은 상태가 2번까지만 존재
			if (s == 3) {
				if (cctvList.get(idx).num == 2) {
					break;
				}
			}
			// cctv 5번은 상태가 1번까지만 존재
			if (s == 2) {
				if (cctvList.get(idx).num == 5) {
					break;
				}
			}
			result[idx] = s;
			subset(idx + 1);
		}
	}

	static int[][] copyMap;

	public static void checkStatus(int[] result) {

		copyMap = new int[N][M];
		deepCopy(map);

		for (int i = 0; i < result.length; i++) {
			// 상태가 1일 때 공통적으로 오른쪽을 향함.
			if (result[i] == 1) {
				right(cctvList.get(i));

				if (cctvList.get(i).num == 2 || cctvList.get(i).num == 4 || cctvList.get(i).num == 5) {
					left(cctvList.get(i));
				}
				if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4 || cctvList.get(i).num == 5) {
					up(cctvList.get(i));
				}
				if (cctvList.get(i).num == 5) {
					down(cctvList.get(i));
				}
			}
			if (result[i] == 2) {
				down(cctvList.get(i));

				if (cctvList.get(i).num == 2 || cctvList.get(i).num == 4) {
					up(cctvList.get(i));
				}

				if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4) {
					right(cctvList.get(i));
				}
			}
			if (result[i] == 3) {
				left(cctvList.get(i));

				if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4) {
					down(cctvList.get(i));
				}
				if (cctvList.get(i).num == 4) {
					right(cctvList.get(i));
				}
			}
			if (result[i] == 4) {
				up(cctvList.get(i));

				if (cctvList.get(i).num == 3 || cctvList.get(i).num == 4) {
					left(cctvList.get(i));
				}
				if (cctvList.get(i).num == 4) {
					down(cctvList.get(i));
				}

			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j =0; j < M; j++) {
//				System.out.print(copyMap[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("============================");
		
		int cnt = 0;
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		min = Math.min(min, cnt);
	}

	public static void right(CCTV cctv) {

		int ny = cctv.j+1;

		while (ny < M) {
			
			if (copyMap[cctv.i][ny] == 6) {
				break;
			}
			// 빈칸이면
			if (copyMap[cctv.i][ny] == 0) {
				copyMap[cctv.i][ny] = 7;
			}
			ny++;
		}
	}

	public static void left(CCTV cctv) {

		int ny = cctv.j-1;

		while (ny >= 0) {
			
			if (copyMap[cctv.i][ny] == 6) {
				break;
			}
			// 빈칸이면
			if (copyMap[cctv.i][ny] == 0) {
				copyMap[cctv.i][ny] = 7;
			}
			ny--;
		}
	}
	public static void up(CCTV cctv) {

		int nx = cctv.i-1;

		while (nx >= 0) {
			
			if (copyMap[nx][cctv.j] == 6) {
				break;
			}
			// 빈칸이면
			if (copyMap[nx][cctv.j] == 0) {
				copyMap[nx][cctv.j] = 7;
			}
			nx--;
		}
	}
	public static void down(CCTV cctv) {

		int nx = cctv.i+1;

		while (nx < N) {
			
			if (copyMap[nx][cctv.j] == 6) {
				break;
			}
			// 빈칸이면
			if (copyMap[nx][cctv.j] == 0) {
				copyMap[nx][cctv.j] = 7;
			}
			nx++;
		}
	}

	public static void deepCopy(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	public static class CCTV {
		int i, j;
		int num; // cctv 번호

		public CCTV(int i, int j, int num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}

		@Override
		public String toString() {
			return "CCTV [i=" + i + ", j=" + j + ", num=" + num + "]";
		}
	}
}