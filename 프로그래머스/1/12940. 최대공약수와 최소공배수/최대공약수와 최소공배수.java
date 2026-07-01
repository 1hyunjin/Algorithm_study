import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = Math.min(n, m);
        int b= Math.max(n, m);
        
        answer[0] = gcd(a, b);
        answer[1] = lcm(a, b);
        
        return answer;
    }
    public int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    public int lcm(int a, int b){
        int c = gcd(a, b);
        return a*b / c;
    }
}