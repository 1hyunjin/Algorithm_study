import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int len = arr[0].length();
        out:for (int i = len - 1; i >= 0; i--) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                String str = arr[j].substring(i, len);
                if (set.contains(str)) {
                    break;
                }
                else{
                    set.add(str);
                }
            }
            if (set.size() == N) {
                System.out.println(len-i);
                break out;
            }
        }
    }
}