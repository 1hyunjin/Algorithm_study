class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < queries.length; j++){
            int s = queries[j][0];
            int e = queries[j][1];
            
            for(int i  = 0; i < s; i++){
                sb.append(my_string.charAt(i));
            }
            for(int i = e; i >= s; i--){
                sb.append(my_string.charAt(i));
            }
            for(int i = e+1; i < my_string.length(); i++){
                sb.append(my_string.charAt(i));
            }
            my_string = sb.toString();
            sb.setLength(0);
        }
        return my_string;
    }
}