import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean hasC = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C') {
                hasC = true;
                break;
            }
        }
        if (!hasC) {
            System.out.println("NO OUTPUT");
            return;
        }
        long cur = 0;
        boolean hasCur = false;
        char op = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            if (sb.length() > 0) {
                long num = Long.parseLong(sb.toString());
                sb.setLength(0);

                if (!hasCur) {
                    cur = num;
                    hasCur = true;
                } else if (op != 0) {
                    cur = susic(cur, op, num);
                }
            }
            if (c == 'C') {
                result.append(cur).append(" ");
            }
            else{
                op = c;
            }
        }
        System.out.println(result.toString());
    }

    public static long susic(long A, char order, long num) {
        switch (order) {
            case 'S':
                return A - num;
            case 'M':
                return A * num;
            case 'U':
                return A / num;
            case 'P':
                return A + num;
            default:
                return 0;
        }
    }
}