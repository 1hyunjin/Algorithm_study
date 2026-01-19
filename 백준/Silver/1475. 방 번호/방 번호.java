import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = String.valueOf(N);
        int[] arr = new int[11];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i)-'0';
            if (num == 6 || num == 9) {
                if(arr[6] < arr[9]){
                    arr[6]++;
                    max = Math.max(max, arr[9]);
                }
                else if (arr[6] > arr[9]) {
                    arr[9]++;
                    max = Math.max(max, arr[6]);
                }
                else{
                    arr[num]++;
                    max = Math.max(max, arr[num]);
                }
            }
            else{
                arr[num]++;
                max = Math.max(max, arr[num]);
            }
        }
        System.out.println(max);
    }
}