import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashSet<String> set = new HashSet<>();

        int index = 1;
        int i = 0;

        while (true) {
            if (i == str.length()-1) {
                break;
            }
            if (i + index > str.length()) {
                i++;
                index = 1;
            }
            String tmp = str.substring(i, i + index);
            index++;
            set.add(tmp);
        }
        System.out.println(set.size());
    }
}