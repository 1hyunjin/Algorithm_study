import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }
        int[] rank = new int[N];
        for (int i = 0; i < N; i++) {
            rank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rank);
        List<Integer> rest = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (set.contains(rank[i])) {
                set.remove(rank[i]);
            }
            else{
                rest.add(rank[i]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Collections.sort(rest);
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.abs(list.get(i) - rest.get(i));
        }
        System.out.println(sum);
    }
}