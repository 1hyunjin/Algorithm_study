import java.io.*;
import java.util.*; 

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = func(arrayA);
        int b = func(arrayB);
        
        // System.out.println("a : " + a);
        // System.out.println("B : " + b);
        // boolean isDividedA = false;
        // boolean isDividedB = false;
        // for(int i = 0; i < arrayB.length; i++){
        //     if(arrayB[i] % a == 0){
        //         isDividedA = true;
        //         break;
        //     }
        // }
        if(isDivided(a, arrayB)){
            answer = Math.max(answer, a);
        }
        if(isDivided(b, arrayA)){
            answer = Math.max(answer, b);
        }
        
        return answer;
    }
    
    public boolean isDivided(int num, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % num == 0){
                return false;
            }
        }
        return true;
    }
    public int func(int[] arr){
        int result = arr[0];
        for(int i = 1; i < arr.length; i++){
            result = getNum(result, arr[i]);
        }
        return result;
    }
    public int getNum(int a, int b){
        int min = Math.min(a, b);
        for(int i = min; i >= 1; i--){
            if(a%i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
}