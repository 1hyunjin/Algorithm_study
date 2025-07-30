import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        while (n!=1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else{
                n = 3*n + 1;
            }
            idx++;
        }
        System.out.println(idx);
    }
}
