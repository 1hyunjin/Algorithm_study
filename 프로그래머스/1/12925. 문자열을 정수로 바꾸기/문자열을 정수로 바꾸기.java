class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0) == '-'){
            answer = Integer.parseInt(s);
            return answer;
        }
        else if(s.charAt(0) == '+'){
            String tmp = s.substring(1, s.length());
            System.out.println(tmp);
            answer = Integer.parseInt(tmp);
        }
        else{
            return Integer.parseInt(s);
        }
        return answer;
    }
}