import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int guest = Integer.parseInt(st.nextToken());
            int[][] map = new int[h+1][w+1];
            int cnt = 0;
            out:for (int i = 1; i <= w; i++) {
                for (int j = 1; j <= h; j++) {
                    cnt++;
                    if (cnt == guest) {
                        sb.append(j);
                        if (i < 10) {
                            sb.append(0).append(i);
                        }
                        else{
                            sb.append(i);
                        }
                        sb.append("\n");
                        break out;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}