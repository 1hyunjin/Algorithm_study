import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int re = (~N) + 1;
        int cnt = 0;
        int xor = N ^ re;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) == (1<<i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}