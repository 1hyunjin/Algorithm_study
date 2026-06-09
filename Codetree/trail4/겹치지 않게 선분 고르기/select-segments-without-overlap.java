import java.util.*;
import java.io.*;

public class Main {
    static int N, max;
    static Point[] arr;
    static int[] answer;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new Point[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        answer = new int[N];
        isSelected = new boolean[N];
        max = 0;
        func(0,0);
        System.out.println(max);
    }
    public static void func(int cnt, int idx){
        if(idx == N){
            if(checkLine()){
                max = Math.max(max, cnt);
            };
            return;
        }
        isSelected[idx] = true;
        func(cnt+1, idx+1);
        isSelected[idx] = false;
        func(cnt, idx+1);
    }
    public static boolean checkLine(){

        int[] lines = new int[1001];
        for(int i = 0; i < N; i++){
            Point cur = arr[i];
            if(isSelected[i]){
                for(int j = cur.x; j <= cur.y; j++){
                    lines[j]++;
                }
            }
        }
        for(int i = 0; i < 1001; i++){
            if(lines[i] > 1){
                return false;
            }
        }
        return true;
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}