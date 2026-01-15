import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            }
            else{
                map.put(title, 1);
            }
            max = Math.max(max, map.get(title));
        }
        List<String> list = new ArrayList<>();
        for (String title : map.keySet()) {
            if (map.get(title) == max) {
                list.add(title);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}