import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        int n = files.length;
        List<File> list = new ArrayList<>(); 
        
        for(int i = 0; i < n; i++){
            String file = files[i];
            int len = file.length();
            int start = 0; 
            while(start < len && !Character.isDigit(file.charAt(start))){
                start++;
            }
            String head = file.substring(0, start);
            int end = start;
            int cnt = 0; 
            while(end < len && Character.isDigit(file.charAt(end)) && cnt < 5){
                end++;
                cnt++;
            }
            String number = file.substring(start, end);
            String tail = "";
            if(end != file.length()){
                tail = file.substring(end, file.length());
            }
            list.add(new File(head, number, tail, i));
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i =0 ; i < list.size(); i++){
            StringBuilder sb = new StringBuilder();
            File file = list.get(i);
            sb.append(file.head).append(file.number).append(file.tail);
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int idx; // 입력 순서
        
        public File(String head, String number, String tail, int idx){
            this.head = head;
            this.number= number;
            this.tail = tail;
            this.idx = idx;
        }
        @Override
        public int compareTo(File o){
            // head 비교 
            int headComp = this.head.toUpperCase().compareTo(o.head.toUpperCase());
            if(headComp != 0){
                return headComp;
            }
            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(o.number);
            int numComp = Integer.compare(num1, num2);
            if(numComp != 0){
                return numComp;
            }
            return Integer.compare(this.idx, o.idx);
        }
        @Override
        public String toString() {
            return String.format("[%s / %s / %s]", head, number, tail);
        }
        
    }
}