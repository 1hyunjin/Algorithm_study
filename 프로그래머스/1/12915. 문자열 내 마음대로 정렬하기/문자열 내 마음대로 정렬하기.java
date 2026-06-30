import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        //  Arrays.sort(strings, new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         if (a.charAt(n) != b.charAt(n)) {
        //             return a.charAt(n) - b.charAt(n);
        //         }
        //         return a.compareTo(b);
        //     }
        // });
        // return strings;
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(n) != b.charAt(n)){
                    return a.charAt(n) - b.charAt(n);
                }
                return a.compareTo(b);
            }
        });
        for(int i =0; i < strings.length; i++){
            queue.offer(strings[i]);
        }
        String[] answer = new String[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()){
            answer[idx++] = queue.poll();
        }
        return answer;
    }
}