import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static List<Point> list;
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		list = new ArrayList<>();
		queue = new ArrayDeque<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new Point(i, j)); // 0인 애들 좌표 모아두기
				}
			}
		}
		// end input
		wall = new Point[3];
		isSelected = new boolean[list.size()];
		func(0, 0);

		System.out.println(max);
	}

	static Point[] wall;
	static boolean[] isSelected;
	static int[][] tmp;
	
	public static void deepCopy(int[][] map) {
		tmp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}
	
	public static void func(int idx, int cnt) {
		// 0의 개수중에 3개를 뽑아 벽을 만드는 과정. (조합)
		if (cnt == 3) {
			deepCopy(map);
			makeWall(wall);
			return;
		}
		if(idx == list.size()) {
			return;
		}
		isSelected[idx] = true;
		wall[cnt] = list.get(idx);
		func(idx+1, cnt+1);
		isSelected[idx] = false;
		func(idx+1, cnt);
	}

	public static void makeWall(Point[] wall) {

		for (int i = 0; i < wall.length; i++) {
			tmp[wall[i].i][wall[i].j] = 1; // 벽으로 바꾸기
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 2) {
					queue.add(new Point(i, j));
				}
			}
		}
		bfs();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int max = Integer.MIN_VALUE;
	static boolean[][] visited;
	
	public static void bfs() {
		
		while (!queue.isEmpty()) {

			Point virus = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = virus.i + dx[d];
				int nextj = virus.j + dy[d];

				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && tmp[nexti][nextj] == 0) {
					queue.add(new Point(nexti, nextj));
					tmp[nexti][nextj] = 2;
				}
			}
		}	
		int zeroCnt = 0;
		// 0의 개수 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		max = Math.max(zeroCnt, max);

	}

	public static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}

	}

}