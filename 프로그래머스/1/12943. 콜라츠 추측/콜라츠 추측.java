class Solution {
    public int solution(int num) {
        int answer = 0;
        int turn = 0;
        long n = num;
        while(true){
            if(n == 1){
                return turn;
            }
            if(turn == 500){
                if(n != 1){
                    return -1;
                }
                else{
                    return turn;
                }
            }
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n = (n*3)+1;
            }
            turn++;
        }
    }
}