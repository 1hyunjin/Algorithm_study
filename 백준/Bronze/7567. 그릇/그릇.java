import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char prev = s.charAt(0);
        int h = 10;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(prev == cur){
                h+=5;
            }
            else{
                h+=10;
            }
            prev = cur;
        }
        System.out.println(h);
    }
}