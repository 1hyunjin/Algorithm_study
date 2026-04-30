class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        StringBuilder sb1 = new StringBuilder();
        sb1.append(b).append(a);
        
        int left = Integer.parseInt(sb.toString());
        int right = Integer.parseInt(sb1.toString());
        if(left >= right){
            answer = left;
        }
        else{
            answer = right;
        }
        
        return answer;
    }
}