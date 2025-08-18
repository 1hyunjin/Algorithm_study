import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i < N; i++){
            map.put(friends[i], i);
        }
        int[][] arr = new int[N][N];
        int[][] list = new int[N][2];   // 선물 지수 계산 
        int[] next = new int[N];
        for(int i = 0; i < gifts.length; i++){
            String s = gifts[i];
            String[] ss = s.split(" ");
            String giver = ss[0];
            String getter = ss[1];
            int x = map.get(giver);
            int y = map.get(getter);
            arr[x][y] += 1;
            list[x][0] += 1; // 선물 준 사람 +1 해주기
            list[y][1] += 1; // 선물 받은 사람 +1 해주기 
        }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("-------------------");
        // for(int i =0; i < N; i++){
        //     for(int j = 0; j < 2; j++){
        //         System.out.print(list[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i < N-1; i++){
            for(int j = i; j < N; j++){
                if(i == j) continue; // 자기자신은 배제
                int a = arr[i][j];
                int b = arr[j][i];
                if((a == 0 && b == 0) || (a == b)){ // 주고 받은 기록이 없거나, 주고받은 갯수 같다면?
                    int aLevel = list[i][0] - list[i][1];
                    int bLevel = list[j][0] - list[j][1];
                    if(aLevel > bLevel){
                        next[i]++;
                    }else if(aLevel < bLevel){
                        next[j]++;
                    }
                }
                else {
                    if(a > b){
                        next[i]++;
                    }
                    else if(a < b){
                        next[j]++;
                    }
                }
            }
        }
        for(int i =0; i < N; i++){
            answer = Math.max(answer, next[i]);
        }
        return answer;
    }
}