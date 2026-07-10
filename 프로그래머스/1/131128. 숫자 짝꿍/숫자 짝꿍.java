import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] xNums = new int[10];
        int[] yNums = new int[10];
        for(int i = 0; i < X.length(); i++){
            int num = X.charAt(i)-'0';
            xNums[num]++;
        }
        for(int i = 0; i < Y.length(); i++){
            int num = Y.charAt(i)-'0';
            yNums[num]++;
        }
        // System.out.println(Arrays.toString(xNums));
        // System.out.println(Arrays.toString(yNums));
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(xNums[i], yNums[i]);
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        if(sb.length() == 0){
            return "-1";
        }
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}