import java.io.*;
import java.util.*;

public class Main {
    static int[][] player;
    static boolean[] isUsed;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            player = new int[11][11];
            isUsed = new boolean[11];

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;

            perm(0, 0);

            System.out.println(max);
        }
    }

    public static void perm(int cnt, int sum) {

        if (cnt == 11) {
            max = Math.max(max, sum);
        }

        for(int i = 0; i < 11; i++){
            if(!isUsed[i] && player[i][cnt] != 0){
                isUsed[i] = true;
                perm(cnt + 1, sum + player[i][cnt]);
                isUsed[i] = false;
            }
        }
    }
}