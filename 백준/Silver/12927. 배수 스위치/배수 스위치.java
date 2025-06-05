import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] bulbs = new char[str.length()+1];

        for (int i = 0; i < str.length(); i++) {
            bulbs[i+1] = str.charAt(i);
        }
        int cnt = 0;
        for (int i = 1; i < bulbs.length; i++) {
            if (bulbs[i] == 'N') {
                continue;
            }
            for (int j = i; j < bulbs.length; j += i) {
                if (bulbs[j] == 'N') {
                    bulbs[j] = 'Y';
                }
                else{
                    bulbs[j] = 'N';
                }
            }
            cnt++;
        }
        for (int i = 1; i < bulbs.length; i++) {
            if (bulbs[i] == 'Y') {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}