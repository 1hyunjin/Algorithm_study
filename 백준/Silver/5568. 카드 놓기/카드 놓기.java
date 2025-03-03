import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] cards;
    static boolean[] used;
    static int[] result;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new int[n];
        used = new boolean[n];
        result = new int[k];

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();

        perm(0);
        System.out.println(set.size());
    }

    public static void perm(int cnt) {

        if (cnt == k) {
            String str = "";
            for (int i = 0; i < k; i++) {
                str += result[i];
            }
            set.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                result[cnt] = cards[i];
                perm(cnt+1);
                used[i] = false;
            }
        }
    }
}