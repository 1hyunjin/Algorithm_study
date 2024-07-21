import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List[] adjList;
	static int N, M;
	static int[] num;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N+1];
		
		adjList = new LinkedList[N+1];
		
		for(int v = 0; v < adjList.length; v++) {
			adjList[v] = new LinkedList<>();
			 // 모든 정점들이 자기의 인접 정보를 저장할 수 있도록 각각 리스트 생성해주기
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			num[b]++;	// 진입 차수 증가시키기 
			adjList[a].add(b);
		}
		
//		for (List list : adjList) {
//			System.out.println(list);
//		}
		
//		System.out.println("각 숫자의 진입차수: " + Arrays.toString(num));
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i < num.length; i++) {
			if(num[i] == 0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
//		System.out.println("진입차수가 0인 것들 큐에 넣기 : " + queue);
		
		while(!queue.isEmpty()) {
			int current = queue.poll(); // 차수가 0인 노드 
//			System.out.println(current);
			sb.append(current + " ");
			int size = adjList[current].size();
			for(int j = 0; j < size; j++) {
				int adjNum = (int) adjList[current].get(j);
//				System.out.println(adjNum);
				num[adjNum]--;
				if(num[adjNum] == 0) {
					queue.add(adjNum);
				}
			}
//			System.out.println(adjList[current]);
			
		}
		
		System.out.println(sb.toString());
	}

}