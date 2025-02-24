import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        arr[0] = 0;
        
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i-1] + i;    
        }
        
        int s = 0;
        int e = 1; 
        int cnt = 0; 
        while(e < n+1){
            
            if(arr[e] - arr[s] < n){
                // System.out.println("s : " + s + " , e: " + e + " arr[e] - arr[s] = " + (arr[e] - arr[s]) + " ,뺀 값이 작네? end 증가!");
                e++;
            }
            else if(arr[e] - arr[s] > n){
                // System.out.println("s : " + s + " , e: " + e + " arr[e] - arr[s] = " + (arr[e] - arr[s]) + " ,뺀 값이 크네? start 증가!");
                s++;
            }
            else if(arr[e]- arr[s] == n){
                // System.out.println("s : " + s + " , e: " + e + " arr[e] - arr[s] = " + (arr[e] - arr[s]) + " ,뺀 값이 n과 동일!!");
                s++;
                e++;
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
}