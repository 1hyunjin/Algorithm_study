class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i = 1; i < numLog.length; i++){
            int a = numLog[i];
            int b = numLog[i-1];
            if(a == b+1){
                answer += "w";
            }
            else if(a == b-1){
                answer += "s";
            }
            else if(a == b+10){
                answer += "d";
            }
            else if(a == b-10){
                answer += "a";
            }
        }
        return answer;
    }
}