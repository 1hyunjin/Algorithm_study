class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        for(int i = 0; i < db.length; i++){
            String id = db[i][0];
            String pw = db[i][1];
            
            if(id.equals(id_pw[0]) && pw.equals(id_pw[1])){
                answer = "login";
                return answer;
            }
            else if(id.equals(id_pw[0]) && !pw.equals(id_pw[1])){
                answer = "wrong pw";
                return answer;
            }
        }
        
        return "fail";
    }
}