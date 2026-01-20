import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String a1 = "";
        String b1 = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            a1 += a.charAt(i);
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            b1 += b.charAt(i);
        }
        if (Integer.parseInt(a1) > Integer.parseInt(b1)) {
            System.out.println(Integer.parseInt(a1));
        }
        else{
            System.out.println(Integer.parseInt(b1));
        }
    }
}