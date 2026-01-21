import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        if (N == 1) {
            System.out.println(arr[0]);
        }
        else{
            String cur = arr[0];
            for (int j = 1; j < N; j++) {
                String next = arr[j];
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < next.length(); k++) {
                    if (cur.charAt(k) != next.charAt(k)) {
                        sb.append('?');
                    }
                    else{
                        sb.append(cur.charAt(k));
                    }
                }
                cur = sb.toString();
            }
            System.out.println(cur);
        }
    }
}