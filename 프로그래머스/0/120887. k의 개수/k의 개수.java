class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char target = (char)(k+'0');
        for(int num = i; num <= j; num++){
            String s = String.valueOf(num);
            for(int t = 0; t < s.length(); t++){
                if(s.charAt(t) == target){
                    answer++;
                }
            }
        }
        return answer;
    }
}