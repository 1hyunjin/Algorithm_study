import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map  = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
            max = Math.max(max, map.get(book));
        }

        List<String> list = new ArrayList<>();

        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}