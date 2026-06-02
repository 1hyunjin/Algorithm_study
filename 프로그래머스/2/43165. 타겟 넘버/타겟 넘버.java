import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static int size;
    static int target;
    static int[] numbers;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        size = numbers.length;
        arr = new int[size];
        this.numbers = numbers;
        perm(0);
        return answer;
    }
    public static void perm(int idx){
        if(idx == size){
            findTarget();
            return;
        }
        arr[idx] = 1;
        perm(idx+1);
        arr[idx] = 0;
        perm(idx+1);
    }
    public static void findTarget(){
        int sum = 0;
        for(int i = 0; i < size; i++){
            int op = arr[i];
            int num = numbers[i];
            if(op == 1){
                sum += num;
            }
            else{
                sum -= num;
            }
        }
        if(sum == target){
            answer++;
        }
    }
}