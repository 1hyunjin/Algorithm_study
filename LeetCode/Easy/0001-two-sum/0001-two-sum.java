import java.io.*;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int na = target - nums[i];

            if(map.containsKey(na)){
                return new int[]{map.get(na), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}