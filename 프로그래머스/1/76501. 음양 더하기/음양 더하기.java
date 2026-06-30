class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            int n = absolutes[i];
            if(!signs[i]){
                answer -= n;
            }
            else{
                answer += n;
            }
        }
        return answer;
    }
}