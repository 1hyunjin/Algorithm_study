class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        
        int left = Integer.parseInt(sb.toString());
        int right = 2*a*b;
        if(left >= right){
            answer = left;
        }
        else{
            answer = right;
        }
        return answer;
    }
}