class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        int idx = my_string.length()-1;
        for(int i = 0; i < n; i++){
            sb.append(my_string.charAt(idx));
            idx--;
        }
        return sb.reverse().toString();
    }
}