import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer = myStr.split("a|b|c");
        List<String> list = new ArrayList<>();
        for(String s : answer){
            if(s.equals("")){
                continue;
            }
            list.add(s);
        }
        if(list.size() == 0){
            return new String[]{"EMPTY"};
        }
        return list.toArray(new String[0]);
    }
}