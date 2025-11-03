import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sb = s.split("-");

        int res = 0;
        for (int i = 0; i < sb.length; i++) {
            String[] add = sb[i].split("\\+");
            int tmp = 0;
            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]);
            }
            if (i == 0) {
                res += tmp;
            }
            else{
                res -= tmp;
            }
        }
        System.out.println(res);
    }
}