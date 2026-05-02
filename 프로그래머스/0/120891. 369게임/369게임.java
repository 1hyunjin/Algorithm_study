class Solution {
    public int solution(int order) {
        int answer = 0;
        String s = String.valueOf(order);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '3' || c == '6' || c == '9'){
                answer++;
            }
        }
        return answer;
    }
}