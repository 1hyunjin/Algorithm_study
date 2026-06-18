import java.util.*;

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        System.out.println(Arrays.toString(arr));
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        if(arr[1].equals("+")){
            return a+b;
        }
        else if(arr[1].equals("-")){
            return a-b;
        }
        else {
            return a*b;
        }
    }
}