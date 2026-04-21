import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        String input = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (!str.equals("all") && !str.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (str) {
                case "add":
                    map.put(x, x);
                    break;
                case "remove":
                    map.remove(x);
                    break;
                case "check":
                    if (map.get(x) != null) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    if (map.get(x) != null) {
                        map.remove(x);
                    }
                     else {
                        map.put(x, x);
                    }
                    break;
                case "all":
                    map.clear();
                    for (int j = 1; j <= 20; j++) {
                        map.put(j, j);
                    }
                    break;

                case "empty":
                    map.clear();
                    break;
            }
        }
        input = sb.toString();
        System.out.println(input);
    }
}
