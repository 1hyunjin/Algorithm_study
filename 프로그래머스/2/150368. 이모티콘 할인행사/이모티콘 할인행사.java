import java.util.*;
import java.io.*;

class Solution {
    static int m;
    static int[] discounts = {10,20,30,40};
    static int[] result;
    static int join; // 가입자 수 
    static int total; // 이모티콘 판매액
    static int[][] people;
    static Map<Integer, Integer> map;
    public int[] solution(int[][] users, int[] emoticons) {
        
        people = new int[users.length][2];
        for(int i = 0; i < users.length; i++){
            people[i][0] = users[i][0];
            people[i][1] = users[i][1];
        }
        m = emoticons.length; 
        map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(i, emoticons[i]);
        }
        result = new int[m];
        join = 0; 
        total = 0; 
        perm(0);
        int[] answer = {join, total};
        return answer;
    }
    public static void perm(int cnt){
        if(cnt == m){
            // System.out.println(Arrays.toString(result));
            // 이모티콘 구매 비용 & 서비스 가입 여부 확인 
            check(result);
            return;
        }
        for(int i = 0; i < 4; i++){
            result[cnt] = discounts[i];
            perm(cnt+1);
        }
    }
    public static void check(int[] result){
        int plus = 0; 
        int sum = 0; 
        for(int i = 0; i < people.length; i++){
            int buy = 0; 
            int percent = people[i][0];
            int limit = people[i][1];
            // 사람이 정한 비율 할인보다 크다? -> 사야해.
            for(int j = 0; j < m; j++){
                if(percent <= result[j]){
                    // System.out.println(i + " 가 " + map.get(j) + "금액의 이모티콘 살 수 있음");
                    int jeongga = map.get(j);
                    int sale = jeongga - (jeongga*result[j])/100;
                    // System.out.println("sale 금액 : " + sale);
                    buy += sale;
                }       
            }
            // 모든 이모티콘 계산해봤을 때 기준 금액 넘으면 플러스로 구독 
            if(limit <= buy ){
                plus++;
                 
            }
            else{
                sum+=buy;
            }
        }
        // System.out.println("plus : " + plus + " , sum : " + sum );
        if(join < plus){
            join = plus;
            total = sum;
        }
        else if(join == plus){
            total = Math.max(total, sum);
        }
    }
}