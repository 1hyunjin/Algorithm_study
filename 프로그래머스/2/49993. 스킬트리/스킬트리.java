import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int n = skill.length();
        char[] arr = new char[n];
        for(int s = 0; s < n; s++){
            arr[s] = skill.charAt(s);
        }
        int T = skill_trees.length;
        
        loop:for(int t = 0; t < T; t++){
            String str = skill_trees[t];
            int size = str.length();
            int cur = 0; 
            
            for(int i = 0; i < size; i++){
                char sk = str.charAt(i);
                for(int j = 0; j < n; j++){
                    if(sk == arr[j]){
                        if(cur == j){
                            cur++;
                        }
                        else if(cur < j){
                            continue loop;
                        }
                        break;
                    }
                }
            }
            answer++;
        }    
        return answer;
    }
}