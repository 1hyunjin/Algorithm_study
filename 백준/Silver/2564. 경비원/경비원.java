import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            arr[i] = new Point(dir, loc);
        }
        st = new StringTokenizer(br.readLine());
        int dongDir = Integer.parseInt(st.nextToken());
        int dongLoc = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            Point cur = arr[i];
            // 동근이랑 같은 위치라면?
            if (cur.dir == dongDir) {
                sum += Math.abs(dongLoc - cur.loc);
            } else if ((dongDir == 1 && cur.dir == 2) || (dongDir == 2 && cur.dir == 1)) {
                sum += sero;
                sum += Math.min(cur.loc + dongLoc, (garo - cur.loc) + (garo - dongLoc));

            } else if ((dongDir == 3 && cur.dir == 4) || (dongDir == 4 && cur.dir == 3)) {
                sum += garo;
                sum += Math.min(cur.loc + dongLoc, (sero - cur.loc) + (sero - dongLoc));

            } else if ((dongDir == 1 && cur.dir == 3) || (dongDir == 3 && cur.dir == 1)) {
                sum += cur.loc + dongLoc;
            }
            else if (dongDir == 1 && cur.dir == 4) {
                sum += (garo - dongLoc) + cur.loc;
            }
            else if(dongDir == 4 && cur.dir == 1){
                sum += (garo - cur.loc) + dongLoc;
            }
            else if (dongDir == 2 && cur.dir == 3) {
                sum += (sero - cur.loc) + dongLoc;
            }
            else if(dongDir == 3 && cur.dir == 2){
                sum+= (sero - dongLoc) + cur.loc;
            }
            else if (dongDir == 2 && cur.dir == 4) {
                sum += (sero - cur.loc) + (garo - dongLoc);
            }
            else if(dongDir == 4 && cur.dir == 2){
                sum += (sero - dongLoc) + (garo - cur.loc);
            }
        }
        System.out.println(sum);
    }

    public static class Point {
        int dir;
        int loc;

        public Point(int dir, int loc) {
            this.dir = dir;
            this.loc = loc;
        }
    }
}
