import java.util.*;

class Solution {
    static String tmp;
    static String message;
    public int solution(String message, int[][] spoiler_ranges) {
        this.message = message;
        String[] messages = message.split(" ");
        
        tmp = message;
        for(int i = 0; i < spoiler_ranges.length; i++){
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            
            makeSpoiler(start, end);
        }
        String[] tmpArr = tmp.split(" ");

        Set<String> words = new HashSet<>();
        Set<String> spoilers = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < tmpArr.length; i++){
            String s = tmpArr[i];
            if(s.contains("*")){
                spoilers.add(messages[i]);
                list.add(messages[i]);
            }
            else{
                words.add(messages[i]);
            }
        }
        
        Set<String> importantWords = new HashSet<>(); // 중요한 단어 
        for(int i = 0; i < list.size(); i++){
            String word = list.get(i);
            // 메시지의 스포 방지 구간이 아닌 구간에 등장한 적이 없어야 한다. 
            if(words.contains(word)) continue;
            // 이전에 공개된 스포 방지 단어와 중복되면 안된다.
            if(importantWords.contains(word)) continue;
            importantWords.add(word);
        }
        int answer = importantWords.size();
        return answer;
    }
    public static void makeSpoiler(int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tmp.length(); i++){
            char c = tmp.charAt(i);
            if(i >= start && i <= end){
                if(Character.isDigit(c) || Character.isAlphabetic(c)){
                    sb.append("*");
                }
                else if(c == '*'){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            else{
                sb.append(c);
            }
        }
        tmp = sb.toString();
    }
}