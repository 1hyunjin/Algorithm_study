import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, str);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (map.containsKey(check)) {
                count++;
            }
        }

        System.out.println(count);
    }
}