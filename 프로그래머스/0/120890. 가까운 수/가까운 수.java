import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int len = array.length;
        int[] cha = new int[len];
        for(int i = 0; i < len; i++){
            cha[i] = Math.abs(array[i]-n);
        }
        int val = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(cha));
        for(int i = 0; i < len; i++){
            if(cha[i] < min){
                min = cha[i];
                val = array[i];
            }
            else if(cha[i] == min){
                if(val > array[i]){
                    val = array[i];
                }
            }
        }
        return val;
    }
}