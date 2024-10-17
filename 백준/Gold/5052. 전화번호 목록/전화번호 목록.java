import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < TC; tc++){
            int n = Integer.parseInt(br.readLine());
            String[] phone_number = new String[n];
            for(int i = 0; i < n; i++){
                phone_number[i] = br.readLine();
            }
            Arrays.sort(phone_number);

            boolean isInclude = false;
            for (int i = 1; i < n; i++) {
                if (phone_number[i].startsWith(phone_number[i - 1])) {
                    isInclude = true;
                    break;
                }
            }
            if(isInclude){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}