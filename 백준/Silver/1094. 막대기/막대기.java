import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (X > 0) {
            X &= (X-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}