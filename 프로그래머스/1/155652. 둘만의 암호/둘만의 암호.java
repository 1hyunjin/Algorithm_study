import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < skip.length(); i++){
            set.add(skip.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            while(cnt < index){
                c++;
                if(c > 'z'){
                    c = 'a';
                }
                if(!set.contains(c)){
                    cnt++;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}