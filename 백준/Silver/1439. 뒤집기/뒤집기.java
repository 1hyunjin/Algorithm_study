import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char prev = str.charAt(0);
        int one = 0;
        int zero = 0;
        if (prev - '0' == 0) {
            zero++;
        }else{
            one++;
        }

        for (int i = 1; i < len; i++) {
            if (prev == str.charAt(i)) {
                continue;
            }
            else{
                if (str.charAt(i) - '0' == 0) {
                    zero++;
                }
                else{
                    one++;
                }
                prev = str.charAt(i);
            }
        }

        int result = 0;
        if(one + zero > 1){
            result = Math.min(one, zero);
        }
        System.out.println(result);
    }
}