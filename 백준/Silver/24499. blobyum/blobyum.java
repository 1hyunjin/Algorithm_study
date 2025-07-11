import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pies = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pies[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < K; i++) {
            sum += pies[i];
            right++;
        }
        max = sum;

        while (left != N) {
            sum-=pies[left];
            left++;
            if(right == N){
                right = 0;
            }
            sum+=pies[right];
            max = Math.max(max, sum);
            right++;
        }
        System.out.println(max);
    }
}