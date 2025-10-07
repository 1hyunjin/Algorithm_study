import java.io.*;
import java.util.*;

class Solution {
    static int cnt;
    public int solution(int n, int k) {
        int answer = -1;
        cnt = 0; 
        change(n, k);
        return cnt;
    }
    public static void change(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n%k);
            n = n/k;
        }
        
        String s = sb.reverse().toString();
        System.out.println(s);
        find(s);
    }
    public static void find(String s){
        String[] sp = s.split("0");
        System.out.println(Arrays.toString(sp));
        for(String str : sp){
            if(!str.equals("")){
                Long number = Long.parseLong(str);
                // System.out.println(number);
                if(isPrime(number)){
                    cnt++;
                }
            }
        }       
    }
    public static boolean isPrime(Long number){
        if(number == 1){
            return false;
        }
        else if(number == 2){
            return true; 
        }
        // else if(number % 2 == 0){
        //     return false;
        // }
        for(int i = 3; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}