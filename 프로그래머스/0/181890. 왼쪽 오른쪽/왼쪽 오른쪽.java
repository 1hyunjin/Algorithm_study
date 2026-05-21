class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        int idx = 0;
        String op = "";
        for(int i= 0; i < str_list.length; i++){
            String s = str_list[i];
            if(s.equals("l")){
                idx = i;
                op = "l";
                break;
            }
            else if(s.equals("r")){
                idx = i+1;
                op = "r";
                break;
            }
        }
        if(op.equals("l")){
            answer = new String[idx];
            for(int i= 0; i < idx; i++){
                answer[i] = str_list[i];
            }
        }
        else if(op.equals("r")){
            answer =new String[str_list.length-idx];
            for(int i = idx; i < str_list.length; i++){
                answer[i-idx] = str_list[i];
            }
        }
        return answer;
    }
}