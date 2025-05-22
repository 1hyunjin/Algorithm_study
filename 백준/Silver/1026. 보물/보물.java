import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int l = a.get(i);
            int r = b.get(i);
            sum += (l * r);
        }
        System.out.println(sum);
    }
}