import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] line = new char[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            line[i] = s.charAt(i);
        }
        boolean[] eaten = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (line[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if(j < 0 || j >= N) continue;
                    if (line[j] == 'H' && !eaten[j]) {
                        eaten[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}