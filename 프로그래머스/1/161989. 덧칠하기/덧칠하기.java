class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cur = 0;
        for(int s : section){
            if(s <= cur){
                continue;
            }
            cur = s+m-1;
            answer++;
        }
        
        return answer;
    }
}