import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, i );
            arr[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (map.containsKey(question)) {
                System.out.println(map.get(question));
            }
            else {
                System.out.println(arr[Integer.parseInt(question)]);
            }
        }
    }
}