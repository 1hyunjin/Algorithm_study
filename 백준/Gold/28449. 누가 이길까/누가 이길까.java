import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] HI = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            HI[i] = Integer.parseInt(st.nextToken());
        }
        int[] ARC = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(HI);
        Arrays.sort(ARC);

        long Hwin = 0;
        long equal = 0;
        long Awin =0;

        for (int i = 0; i < N; i++) {
            int target = HI[i];

            int low = lowerScore(target, ARC);
            int up = upperScore(target, ARC);

            long winCnt = M-up;
            long draw = up - low;

            Hwin += low;
            Awin += winCnt;
            equal += draw;
        }
        System.out.println(Hwin + " " + Awin + " " + equal);
    }

    public static int lowerScore(int target, int[] ARC) {
        int l =0 ;
        int r = ARC.length;

        while (l < r) {
            int mid = (l+r)/2;
            if (ARC[mid] >= target) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }

    public static int upperScore(int target, int[] ARC) {
        int l = 0;
        int r = ARC.length;
        while (l < r) {
            int mid = (l+r)/2;
            if (ARC[mid] > target) {
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}