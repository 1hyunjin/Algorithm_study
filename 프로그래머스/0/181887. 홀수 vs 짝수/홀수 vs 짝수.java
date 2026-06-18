import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int even = 0;
        int odd = 0;
        for(int i =0; i < num_list.length; i++){
            if((i+1)%2 == 0){
                odd += num_list[i];
            }
            else{
                even += num_list[i];
            }
        }
        int max = Integer.MIN_VALUE;
        max = Math.max(max, even);
        max = Math.max(max, odd);
        return max;
    }
}