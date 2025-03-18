import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int m = Integer.parseInt(br.readLine());
            if(m == 0){
                break;
            }
            String str = br.readLine(); 
            int[] alpha = new int[128];
            int left = -1; 
            int right = -1;
            int cnt = 0; 
            int max = 0; 

            while(left <= right && right < str.length()-1){
                // 작으면 
                if(cnt < m){
                    right++; // right 증가 
                    alpha[str.charAt(right)]++;

                    // 처음 사용하는거면 cnt 증가  
                    if(alpha[str.charAt(right)] == 1){
                        cnt++;
                    }
                }
                else if(cnt == m && alpha[str.charAt(right+1)] > 0){
                    right++; 
                    alpha[str.charAt(right)]++;
                }
                else {
                    left++; 
                    alpha[str.charAt(left)]--;

                    if(alpha[str.charAt(left)] == 0){
                        cnt--;
                    }
                }
                max = Math.max(max, right - left);

                if(left == str.length()-1){
                    break;
                }
            }
            System.out.println(max);
        }
    }
}