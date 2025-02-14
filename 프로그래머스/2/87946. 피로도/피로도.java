import java.io.*;
import java.util.*;

class Solution {
    static int R;
    static List<Integer> list;
    static boolean[] isSelected;
    static int[] result;
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        R = dungeons.length;
        System.out.println(R);
        list = new ArrayList<>();
        isSelected = new boolean[R];
        result = new int[R];
        max = 0; 
        func(k, dungeons);
        answer = max;
        return answer;
    }
    
    public static void func(int k, int[][] dungeons){
        int cnt = 0;
        for(int i = 0; i < R; i++){
            if(isSelected[i]){
                cnt++;
            }
        }
        
        if(cnt > max){
            max = cnt;
        }
        
        for(int i = 0; i < R; i++){
            if(!isSelected[i]){
                if(k >= dungeons[i][0]){
                    isSelected[i] = true;
                    k -= dungeons[i][1];
                    func(k, dungeons);
                    isSelected[i] = false;
                    k += dungeons[i][1];
                }
            }
        }
    }
}