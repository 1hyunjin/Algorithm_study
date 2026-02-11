import java.io.*;
import java.util.*;

class Main {
    static boolean[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new boolean[11];
        init();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            String s = br.readLine();
            if (s.equals("too high")) {
                for (int i = num; i <= 10; i++) {
                    arr[i] = false;
                }
            } else if (s.equals("too low")) {
                for (int i = 0; i <= num; i++) {
                    arr[i] = false;
                }
            } else {
                if (arr[num]) {
                    sb.append("Stan may be honest").append('\n');
                } else {
                    sb.append("Stan is dishonest").append('\n');
                }
                init();
            }
        }
        System.out.println(sb.toString());
    }

    public static void init() {
        for (int i = 0; i <= 10; i++) {
            arr[i] = true;
        }
    }
}