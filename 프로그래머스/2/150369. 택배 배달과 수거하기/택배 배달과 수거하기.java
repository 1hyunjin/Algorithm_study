import java.io.*;
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del_index = 0;
        int pick_index = 0;
        for(int i=0;i<n;i++){
            if(deliveries[i]!=0){
                del_index = i;
            }
            if(pickups[i]!=0){
                pick_index = i;
            }
        }
        int cur = 0;
        while(true){
            while (del_index >= 0 && deliveries[del_index] == 0) del_index--;
            while (pick_index >= 0 && pickups[pick_index] == 0) pick_index--;
            if (del_index < 0 && pick_index < 0) break;
            answer+=Math.max((del_index+1)*2, (pick_index+1)*2);
            cur = cap;
            for(int i=del_index;i>-1;i--){
                if(deliveries[i]>cur){
                    deliveries[i]-=cur;
                    del_index = i;
                    break;
                }else{
                    cur-=deliveries[i];
                    deliveries[i] = 0;
                }
                if(i==0)del_index = -1;
            }
            cur = cap;
            for(int i=pick_index;i>-1;i--){
                if(pickups[i]>cur){
                    pickups[i]-=cur;
                    pick_index = i;
                    break;
                }else{
                    cur-=pickups[i];
                    pickups[i] = 0;
                }
                if(i==0)pick_index = -1;
            }
            // if(del_index<0 && pick_index<0)break;
        }
        return answer;
    }
}