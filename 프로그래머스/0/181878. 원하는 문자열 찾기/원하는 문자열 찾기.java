class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        if(myString.length() < pat.length()){
            return 0;
        }
        else{
            myString = myString.toUpperCase();
            pat = pat.toUpperCase();
            
            if(myString.contains(pat)){
                return 1;
            }
        }
        return answer;
    }
}