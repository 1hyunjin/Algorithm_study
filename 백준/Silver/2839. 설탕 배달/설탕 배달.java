import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                ans += N/5;
                break;
            } else if (N < 3) {
                ans = -1;
                break;
            }
            else {
                N-=3;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
