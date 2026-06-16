import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" ");
        // for(int i = 0; i < arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        int sang = 0;
        int xsum = 0;
        for(int i = 0; i < arr.length; i++){
            String s = arr[i];
            if(s.equals("+")){
                continue;
            }
             if (s.contains("x")) {
                if (s.equals("x")) {
                    xsum += 1;
                } else {
                    xsum += Integer.parseInt(s.replace("x", ""));
                }
            } else {
                sang += Integer.parseInt(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(xsum > 0){
            if(xsum == 1){
                sb.append("x");
            }
            else{
                sb.append(xsum).append("x");
            }
        }
        if(sang > 0){
            if(sb.length() > 0){
                sb.append(" + ");
            }
            sb.append(sang);
        }
        // System.out.println(xsum);
        // System.out.println(sang);
        return sb.toString();
    }
}