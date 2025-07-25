import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0, y = 0, cnt=0;
        
        Set<String> set = new HashSet<>();
        
        for(char c : dirs.toCharArray()){
            int nx = x;
            int ny = y;
                        
            if(c == 'U'){
                ny++;
            } else if(c == 'D'){
                ny--;
            } else if(c == 'R'){
                nx++;
            } else if(c == 'L'){
                nx--;
            }
            // 경계값을 넘으면 pass
            if(ny < -5 || ny > 5 || nx < -5 || nx > 5) {
                continue;
            }
            String cur = x+","+y+"->"+nx+","+ny;
            String reverse = nx+","+ny+"->"+x+","+y;
            
            x = nx;
            y = ny;
            
            if(set.contains(cur) || set.contains(reverse)){
                continue;
            }
            set.add(cur);
            set.add(reverse);
            
            cnt++;
        }
        return cnt;
    }
}