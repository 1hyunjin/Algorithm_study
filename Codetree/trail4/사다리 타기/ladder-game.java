import java.util.*;
public class Main {
    static List<Point> list;
    static int n, m;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;
    static int[] basic;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int s = sc.nextInt();
            int h = sc.nextInt();
            list.add(new Point(h, s));
        }
        // Please write your code here.
        Collections.sort(list);
        // System.out.println(list);
        selected = new boolean[m];
        basic = makeLadder(list);
        subset(0);
        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min);    
        }
        
    }
    public static void subset(int idx){
        if(idx == m){
            List<Point> tmp = new ArrayList<>();
            for(int i= 0; i < m; i++){
                if(selected[i]){
                    tmp.add(list.get(i));
                }
            }
            boolean isMatch = true;
            int[] answer = makeLadder(tmp);
            for(int i = 1; i <= n; i++){
                if(answer[i] != basic[i]){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                min = Math.min(min, tmp.size());
            }
            return;
        }
        selected[idx] = true;
        subset(idx+1);
        selected[idx] = false;
        subset(idx+1);
    }
    public static int[] makeLadder(List<Point> tmp){
        int[] answer = new int[n+1];
        for(int i = 1; i <= n; i++){
            int curS = i;
            for(int j = 0; j < tmp.size(); j++){
                Point cur = tmp.get(j);
                if(curS == cur.s){
                    curS = curS+1;
                }
                else if(curS == cur.s+1){
                    curS = curS-1;
                }
            }
            answer[curS] = i;
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static class Point implements Comparable<Point> {
        int h;
        int s;

        public Point(int h, int s) {
            this.h = h;
            this.s = s;
        }

        @Override
        public int compareTo(Point o) {
            if (this.h == o.h) {
                return this.s - o.s;
            }
            return this.h - o.h;
        }
        // @Override
        // public String toString(){
        //     return "Point{" + this.h + " , " + this.s + "}";
        // }
    }
}