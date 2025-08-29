import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] sArr, wArr;
    static int cnt, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        sArr = new int[9];
        wArr = new int[9];
        cnt = 0;
        ans = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sArr[i] = s;
            wArr[i] = w;
        }
        func(1); // 1번 계란부터 치니까
        System.out.println(ans);
    }

    public static void func(int pick) {
        if (pick == N + 1) {
            ans = Math.max(ans, cnt);
            return;
        }
        if(sArr[pick] <= 0){    // 픽이 이미 깨졌으면 넘겨
            func(pick+1);
            return;
        }
        boolean hit = false;
        for(int i = 1; i <= N; i++){
            if(pick == i || sArr[i] <= 0) continue; // 픽이랑 같은 계란 번호나 내구도 0이하 (이미 깨린 계란)은 무시
            sArr[pick] -= wArr[i];
            sArr[i] -= wArr[pick];
            if(sArr[pick] <= 0 ) cnt++;
            if(sArr[i] <= 0 ) cnt++;
            hit = true;
            func(pick+1);

            // 되돌리기
            if(sArr[pick] <= 0 )cnt--;
            if(sArr[i] <= 0 ) cnt--;
            sArr[pick] += wArr[i];
            sArr[i] += wArr[pick];
        }
        if (!hit) {
            func(pick+1); // 칠 수 있는게 없으면 pick+1해서 넘김
        }
    }
}