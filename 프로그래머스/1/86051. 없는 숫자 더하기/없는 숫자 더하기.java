import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i =0 ; i < numbers.length; i++){
            set.add(numbers[i]);
        }
        int sum = 0;
        for(int i = 0; i <= 9; i++){
            if(!set.contains(i)){
                sum += i;
            }
        }
        return sum;
    }
}