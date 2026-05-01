import java.io.*;
import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int[] dices = new int[7];
        dices[a]++;
        dices[b]++;
        dices[c]++;
        dices[d]++;
        list.add(a);
        if(!list.contains(b)) list.add(b);
        if(!list.contains(c)) list.add(c);
        if(!list.contains(d)) list.add(d);
        
        if(list.size() == 1){
            answer = list.get(0) * 1111;
        }
        else if(list.size() == 2){
            int p = list.get(0);
            int q = list.get(1);
            int pCnt = dices[p];
            int qCnt = dices[q];
            
            if(pCnt == qCnt && p != q){
                answer = (p+q) * Math.abs(p-q);
            }
            else if(pCnt > qCnt && p!=q){
                answer = (10*p+q) * (10*p+q);
            }
            else if(qCnt > pCnt && p!= q){
                answer = (10*q+p) * (10*q+p);
            }
        }
        else if(list.size() == 3){
            int p = list.get(0);
            int q = list.get(1);
            int r = list.get(2);
            int pCnt = dices[p];
            int qCnt = dices[q];
            int rCnt = dices[r];
            if(pCnt == 2 && q != r){
                answer = q*r;
            }
            else if(qCnt ==2 && p != r){
                answer = p*r;
            }
            else if(rCnt == 2 && p != q){
                answer = p*q;
            }
        }
        else {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++){
                min = Math.min(min, list.get(i));
            }
            answer = min;
        }
        return answer;
    }
}