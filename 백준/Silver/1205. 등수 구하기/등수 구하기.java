import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long score = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Long.parseLong(st.nextToken()));
            }
        }
//        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        if (N == P && score <= list.get(list.size() - 1)) {
            System.out.println(-1);
        }
        else {
            int rank = 1;
            for (int i = 0; i < list.size(); i++) {
                if (score < list.get(i)) {
                    rank++;
                }else{
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}