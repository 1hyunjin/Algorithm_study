import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int len = attacks.length;
        int end = attacks[len-1][0]; // 공격 종료 시간
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < len; i++){
            map.put(attacks[i][0], attacks[i][1]);
        }
        int cur = health; // 현재 체력
        int time = 0; // 연속 시간
        int x = bandage[1]; // 초당 회복력
        int y = bandage[2]; // 추가 회복량
        
        for(int i = 1; i <= end; i++){
            // 공격 없으면 
            if(!map.containsKey(i)){
                cur += x; 
                if(cur > health){
                    cur = health;
                }
                time++;
                if(time == bandage[0]){
                    cur += y;
                    time = 0;
                    if(cur > health){
                        cur = health;
                    }
                }
            }
            else{
                cur -= map.get(i);
                time = 0;
                if( cur <= 0){
                    answer = -1;
                    return answer;
                }
            }
        }
        answer = cur;
        return answer;
    }
}