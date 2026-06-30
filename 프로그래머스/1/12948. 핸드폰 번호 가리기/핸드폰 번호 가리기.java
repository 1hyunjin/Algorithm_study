import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = phone_number.length();
        int cha = idx - 5;
        for(int i = 0; i <= cha; i++){
            sb.append("*");
        }
        for(int i = cha+1; i < idx; i++){
            sb.append(phone_number.charAt(i));
        }
        
        return sb.toString();
    }
}