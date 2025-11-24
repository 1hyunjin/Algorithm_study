import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        list.add(change(sb));
                        sb.setLength(0);
                    }
                }
            }
            if (sb.length() > 0) {
                list.add(change(sb));
            }
        }
        Collections.sort(list,(o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });
        for (String num : list) {
            System.out.println(num);
        }
    }

    public static String change(StringBuilder sb) {
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        if (idx == sb.length()) {
            return "0";
        }
        return sb.substring(idx);
    }
}