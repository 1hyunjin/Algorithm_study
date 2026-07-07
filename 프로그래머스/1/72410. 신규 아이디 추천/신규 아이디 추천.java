import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 1단계
        for(int i =0; i < new_id.length(); i++){
            sb.append(Character.toLowerCase(new_id.charAt(i)));
        }
        answer = sb.toString();
        // 2단계
        String tmp = "";
        for(int i = 0; i < sb.length(); i++){
            char c = answer.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.'){
                tmp += c;
            }
        }
        answer = tmp;
        // 3단계
        StringBuilder third = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);

            if (c == '.') {
                if (third.length() == 0 || third.charAt(third.length() - 1) != '.') {
                    third.append(c);
                }
            } else {
                third.append(c);
            }
        }

        answer = third.toString();
        // System.out.println("3끝 : " + answer);
        // 4단계
        StringBuilder fourth = new StringBuilder();
        for(int i =0; i < answer.length(); i++){
            if(i == 0 && answer.charAt(0) == '.'){
                continue;
            }
            if(i == answer.length()-1 &&  answer.charAt(answer.length()-1) == '.'){
                continue;
            }
            fourth.append(answer.charAt(i));
        }
        answer = fourth.toString();
        // System.out.println("4끝 : " + answer);
        // 5단계
        if(answer.isEmpty()){
            answer += "a";
        }
        // System.out.println("5끝 : " + answer);
        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
        }
        if(answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, 14);
        }
        // System.out.println("6끝 : " + answer);
        // 7단계
        if(answer.length() <= 2){
            char c = answer.charAt(answer.length()-1);
            int cha = 3-answer.length();
            for(int j = 0; j < cha; j++){
                answer += c;
            }
        }
        // System.out.println("7끝 : " + answer);
        return answer;
    }
}