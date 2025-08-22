import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c=0;
        for (int i = 0; i <= 9; i++) {
            if ((a & (1 << i)) == (1 << i)) {
                if ((b & (1 << i)) != (1 << i)) {
                    c|= (1<<i); // c에 삽입
                }
            }
            if ((b & (1 << i)) == (1 << i)) {
                if ((a & (1 << i)) != (1 << i)) {
                    c|= (1<<i); // c에 삽입
                }
            }
        }
        System.out.println(c);
    }
}