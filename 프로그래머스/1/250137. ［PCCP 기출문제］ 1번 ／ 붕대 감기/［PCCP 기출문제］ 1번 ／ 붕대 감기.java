import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int x = attacks.length;
        int end = attacks[x-1][0];  // 공격 종료 시간
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < x; i++){
            map.put(attacks[i][0], attacks[i][1]);
        }
        int cur = health; // 현재 체력 설정
        int time = 0; // 연속 시간
        int t = bandage[1]; // 초당 회복량 
        int addHealth = bandage[2]; // 추가 회복량 , bandage[0] = 시전시간
        
        for(int i = 1; i <= end; i++){
            // 이 시간에 공격이 없다면? 
            if(!map.containsKey(i)){
                cur+=t;
                if(cur > health){
                    cur = health;
                }
                time++;
                if(time == bandage[0]){
                    cur += addHealth;
                    time = 0; 
                    if(cur > health){
                        cur = health;
                    }
                }
            }
            // 공격이 있어? 
            else{
                int attack = map.get(i);
                cur -= attack; // 피해량 빼
                if(cur <= 0){
                    answer = -1; // 체력 0 이하면 죽어 -1 return
                    return answer;
                }
                time = 0; 
            }
        }
        answer = cur;
        return answer;
    }
}