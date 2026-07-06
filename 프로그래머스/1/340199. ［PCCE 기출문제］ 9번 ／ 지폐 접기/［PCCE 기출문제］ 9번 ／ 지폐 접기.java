class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            int billMin = bill[0];
            int billMax = bill[1];
            int walletMin = wallet[0];
            int walletMax = wallet[1];
            if(bill[0] > bill[1]){
                billMin = bill[1];
                billMax = bill[0];
            }
            if(wallet[0] > wallet[1]){
                walletMin = wallet[1];
                walletMax = wallet[0];
            }
            if(billMin <= walletMin && billMax <= walletMax){
                break;
            }
            if(bill[0] > bill[1]){
                bill[0] = bill[0]/2;
            }
            else{
                bill[1] = bill[1]/2;
            }
            answer++;
        }
        return answer;
    }
}