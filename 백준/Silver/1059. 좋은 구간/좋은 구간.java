import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int low = 0;
        int high = 1000;
        int cnt = 0;

        for (int i = 0; i < L; i++) {
            if (list.get(i) == n) {
                cnt++;
                break;
            } else {
                if(list.get(i) < n && low < list.get(i)){
                    low = list.get(i);
                }
                if (list.get(i) > n && high > list.get(i)) {
                    high = list.get(i);
                }
            }
        }
        if (cnt == 1) {
            System.out.println(0);
        } else {
            for (int i = low+1; i <= n; i++) {
                for (int j = n; j < high; j++) {
                    result++;
                }
            }
            System.out.println(result - 1);
        }
    }
}