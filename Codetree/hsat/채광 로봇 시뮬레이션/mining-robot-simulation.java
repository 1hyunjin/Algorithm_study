import java.util.*;
import java.io.*;
public class Main {
    static final int NEG = Integer.MIN_VALUE/4;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 시작점에서 각 칸까지의 최대 이익
        int[][] fromStart = new int[N][N];
        fromStart[0][0] = map[0][0];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                int best = NEG;
                if(i > 0){
                    best = Math.max(best, fromStart[i-1][j]); // 위에서 온 값
                }
                if(j > 0){
                    best = Math.max(best, fromStart[i][j-1]);   // 왼쪽에서 온 값
                }
                fromStart[i][j] = best + map[i][j];
            }
        }

        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(fromStart[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // 2. 각 칸에서 도착점까지의 최대 이익
        int[][] toEnd = new int[N][N];
        toEnd[N-1][N-1] = map[N-1][N-1];

        for(int i = N-1; i >= 0; i--){
            for(int j = N-1; j >= 0; j--){
                if(i == N-1 && j == N-1){
                    continue;
                }
                int best = NEG;
                if(i+1 < N){
                    best = Math.max(best, toEnd[i+1][j]);
                }
                if(j+1 < N){
                    best = Math.max(best, toEnd[i][j+1]);
                }
                toEnd[i][j] = best + map[i][j];
            }
        }
        // System.out.println("--------------------");
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(toEnd[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // 3. 각 칸에서 정확히 T칸 이동했을 때 얻는 최대 추가 이익
        // prev[i][j]: (i, j)에서 정확히 step-1칸 이동하며 얻는 최대 이익
        int[][] prev  = new int[N][N];
        // 0칸 이동할 때 추가 이익은 0
        for(int step = 1; step <= T; step++){
            int[][] cur = new int[N][N];
            
            for(int i = 0; i < N; i++){
                Arrays.fill(cur[i], NEG);
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // 아래로 이동
                    if(i+1 < N && prev[i+1][j] != NEG){
                        cur[i][j] = Math.max(cur[i][j], map[i+1][j] + prev[i+1][j]);
                    }
                    // 오른쪽으로 이동
                    if(j+1 < N && prev[i][j+1]!= NEG){
                        cur[i][j] = Math.max(cur[i][j], map[i][j+1] + prev[i][j+1]);
                    }
                }
            }
            prev = cur;
        }
        // System.out.println("--------------------");
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(prev[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // 장치를 사용하지 않는 경우
        int answer = fromStart[N - 1][N - 1];

        // (i,j)를 T초 전 위치로 설정하고 장치를 사용하는 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 해당 위치에서 정확히 T칸 이동할 수 없는 경우
                if (prev[i][j] == NEG) {
                    continue;
                }

                int total =
                        fromStart[i][j]
                        + prev[i][j]
                        + toEnd[i][j];

                answer = Math.max(answer, total);
            }
        }

        System.out.println(answer);
    }
}