import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> s = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            s.put(name, 0);
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (s.containsKey(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
    }
}