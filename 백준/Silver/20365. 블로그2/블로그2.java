import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int blue = 0;
        int red = 0;
        if(s.charAt(0) == 'B'){
            blue++;
        }
        else{
            red++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            else{
                if(s.charAt(i)== 'B'){
                    blue++;
                }
                else{
                    red++;
                }
            }
        }
        System.out.println(Math.min(blue, red) + 1);
    }
}