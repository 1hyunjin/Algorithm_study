import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        int total = 0;
        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.isEmpty()) {
                break;
            }
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            total++;
        }
        StringBuilder sb = new StringBuilder();
        for (String tree : map.keySet()) {
            int cnt = map.get(tree);
            double ratio = (double) cnt/total * 100;
            sb.append(tree).append(" ").append(String.format("%.4f", ratio)).append("\n");
        }
        System.out.println(sb.toString());
    }
}