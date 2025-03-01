import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0, cnt=0;
        
        Set<String> set = new HashSet<>();
        
        for(char c : dirs.toCharArray()){
            int nx = x;
            int ny = y;
            
            String oppsite = "";
            
            if(c == 'U'){
                oppsite = "D";
                ny++;
            } else if(c == 'D'){
                oppsite = "U";
                ny--;
            } else if(c == 'R'){
                oppsite = "L";
                nx++;
            } else if(c == 'L'){
                oppsite = "R";
                nx--;
            }
            // 경계값을 넘으면 pass
            if(ny < -5 || ny > 5 || nx < -5 || nx > 5) {
                continue;
            }
            // 반대로 길을 지난 경우 
            String before = oppsite+x+y;
            // 똑바로 길을 지난 경우 
            String after = String.valueOf(c) + nx + ny;
            // x, y 좌표 갱신
            x = nx;
            y = ny;
            //똑바로, 반대로 길을 지난 경우면 pass
            if(set.contains(before) || set.contains(after)){
                continue;
            }
            set.add(before);
            set.add(after);
            
            // 처음 지난 길 개수 +1 증가
            cnt++;
        }
        // 정답 처리
        return cnt;
    }
}