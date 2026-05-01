class Solution {
    public String solution(String my_string, int[] indices) {
        boolean[] removed = new boolean[my_string.length()];
        for(int i = 0; i < indices.length; i++){
            removed[indices[i]] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++){
            if(!removed[i]){
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}