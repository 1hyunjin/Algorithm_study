import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int n = park.length;
        int m = park[0].length;
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(park[i][j].equals("-1")){
                    list.add(new Point(i, j));
                }
            }
        }
        // System.out.println(list);
        int max = -1;
        for(int i =0; i < list.size(); i++){
            int curX = list.get(i).x;
            int curY = list.get(i).y;
            for(int j = 0; j < mats.length; j++){
                boolean isMatch = true;
                int len = mats[j];
                if(curX+len > n || curY + len > m){
                    continue;
                }
                out:for(int k = curX; k < (curX+len); k++){
                    for(int l = curY; l < (curY+len); l++){
                        // System.out.println(k + " , " + l);
                        if(k < 0 || k >= n || l < 0 || l >= m){
                            isMatch = false;
                            break out;
                        }
                        if(!park[k][l].equals("-1")){
                            isMatch = false;
                            break out;
                        }
                    }
                }
                if(isMatch){
                    max = Math.max(max, len);
                }
            }
        }
        // System.out.println(max);
        return max;
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "Point { " + this.x + "," + this.y + " }";
        }
    }
}