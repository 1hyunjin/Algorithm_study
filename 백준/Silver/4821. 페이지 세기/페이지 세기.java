import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            String s = br.readLine();
            Set<Integer> set = new HashSet<>();
            String[] chp = s.split(",");
            for (int i = 0; i < chp.length; i++) {
                String[] idx = chp[i].split("-");
                if (idx.length == 1) {
                    int p = Integer.parseInt(idx[0]);
                    if (1 <= p && p <= N) {
                        set.add(p);
                    }
                }
                else{
                    int a = Integer.parseInt(idx[0]);
                    int b = Integer.parseInt(idx[1]);
                    if(a > N) continue;
                    if(b > N) b = N;
                    if ( a <= b ) {
                        for (int j = a; j <=b; j++) {
                            set.add(j);
                        }
                    }
                }
            }
            sb.append(set.size()).append('\n');
        }
        System.out.println(sb.toString());
    }
}