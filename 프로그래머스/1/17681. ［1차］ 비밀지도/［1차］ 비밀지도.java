import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int len = arr1.length;
        for(int i = 0; i < len; i++){
            StringBuilder sb = new StringBuilder();
            int num1 = arr1[i];
            int num2 = arr2[i];

            int sum = (num1|num2);
            String s = Integer.toString(sum, 2);
            
            // System.out.println(Integer.toString(sum, 2));
            int cha = n - s.length();
            for(int j = 0; j < cha; j++){
                sb.append(" ");
            }
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '1'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}