class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(true){
            if(chicken < 10){
                break;
            }
            int service = chicken/10;
            int rest = chicken%10;
            answer += service;
            chicken = service + rest;
        }
        return answer;
    }
}