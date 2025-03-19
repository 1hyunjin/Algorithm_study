import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M;
    static boolean[][] map;
    static int total; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M+1];
        comb(0);
        System.out.println(total);
    }
    public static void comb(int idx){
        if(idx == N*M){
            total++;
            return;
        }
        int r = idx/M+1;
        int c = idx%M+1;
        
        if(map[r-1][c-1] && map[r-1][c] && map[r][c-1]){
            comb(idx+1);
        }
        else {
            map[r][c] = true;
            comb(idx+1);
            map[r][c] = false;
            comb(idx+1);
        }
    }
}