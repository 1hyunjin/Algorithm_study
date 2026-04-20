import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String one = new StringBuilder(s.substring(0, i)).reverse().toString();
                String two = new StringBuilder(s.substring(i, j)).reverse().toString();
                String three = new StringBuilder(s.substring(j, n)).reverse().toString();

                String sum = one+two+three;

                set.add(sum);
            }
        }
        System.out.println(set.first());
    }
}