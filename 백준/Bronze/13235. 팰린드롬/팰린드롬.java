import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s).reverse();
        if (s.equals(sb.toString())) {
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }
}