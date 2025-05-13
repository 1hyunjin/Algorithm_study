import java.io.*;
import java.util.*;

public class Main {
    static int sA, sB, tA, tB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int sLen = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(t);

        while (sb.length()> s.length()) {
            if(sb.charAt(sb.length() - 1) == 'A'){
                sb.deleteCharAt(sb.length() - 1);
            }
            else{
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }
        if (sb.toString().equals(s)) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}