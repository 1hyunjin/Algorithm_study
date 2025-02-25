import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map  = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Long> list = new ArrayList<>();

        for (Long key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}