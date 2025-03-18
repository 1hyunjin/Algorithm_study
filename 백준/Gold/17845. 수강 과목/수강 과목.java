import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Subject[] arr = new Subject[K+1];

        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[0], 0);

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // System.out.println(Arrays.toString(arr));

        for(int i = 1; i <= K; i++){
            for(int j = 0; j <= N; j++){
                if(j-arr[i].T < 0){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].T] + arr[i].I);
                }
            }
        }
        System.out.println(dp[K][N]);
    }
    public static class Subject{
        int I; 
        int T; 

        public Subject(int I, int T){
            this.I = I;
            this.T = T;
        }
        @Override
        public String toString(){
            return "Subject{ " + this.I + " , " + this.T + " }";
        }
    }
}