import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] piece = new int[3];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;
            if (str.equals("1/2")) {
                piece[0]++;
            } else if (str.equals("1/4")) {
                piece[1]++;
            } else {
                piece[2]++;
            }
        }
        int pizza = 0;
        int m = Math.min(piece[1], piece[2]); // 1/4 && 3/4
        pizza += m;
        piece[1] -= m;
        piece[2] -= m;

        pizza += piece[2]; // 남은 3/4

        pizza += piece[0] / 2;
        piece[0] = piece[0] % 2;


        if (piece[0] == 1) { // 1/2 1개 남았
            if (piece[1] >= 2) { // 1/4 2개 -> 1/2되니까
                piece[1] -= 2;
                pizza++;
            } else {
                pizza++;
                piece[1] = 0;
            }
        }
        pizza += piece[1]/4;
        if(piece[1]%4 != 0){
            pizza++;
        }
        System.out.println(pizza);
    }
}