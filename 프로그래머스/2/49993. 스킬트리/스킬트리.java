import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees){
            answer += checkSkill(skill, s);
        }
        return answer;
    }
    
    public int checkSkill(String skill, String s){
        System.out.println(skill + " , " + s);
        
        boolean isFind = false;
        int start = -1;
        boolean notLearn = false;
        
        for(int i = 0; i < skill.length(); i++){
            // System.out.println(i);
            for(int j = 0; j < s.length(); j++){
                if(skill.charAt(i) == s.charAt(j)){
                    if(!notLearn && start < j){
                        start = j;
                        isFind = true;
                        break;
                    }
                    else {
                        System.out.println("0");
                        return 0;
                    }
                }
                else {
                    isFind = false;
                }
            }
            if(!isFind){
                notLearn = true;
            }
        }
        return 1;
    }
}