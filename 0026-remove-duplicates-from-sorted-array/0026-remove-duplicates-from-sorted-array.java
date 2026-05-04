class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int idx = 0;
        for (int num : set) {
            nums[idx] = num;
            idx++;
        }

        return set.size();
    }
}