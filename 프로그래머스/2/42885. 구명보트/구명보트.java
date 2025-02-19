import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int len = people.length;
        Arrays.sort(people);
        
        int s = 0;
        int e = len-1;
        int result = 0;
        while(s <= e){
            
            if(s == e){
                result++;
                break;
            }

            if(people[s] + people[e] > limit){
                result++;
                e--;
            }
            
            else {
                s++;
                e--;
                result++;
            }
        }
        
        answer = result;
        return answer;
    }
}