class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i+=m){
            String row = my_string.substring(i, i+m);
            answer += row.charAt(c-1);
        }
        return answer;
    }
}