import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] dir = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dir);

        int answer = 0;
        double len = 0;

        for (int i = 0; i < N; i++) {
            if (dir[i] > len) {
                answer++;
                len = dir[i] + L - 0.5;
            }
        }

        System.out.println(answer);
    }
}