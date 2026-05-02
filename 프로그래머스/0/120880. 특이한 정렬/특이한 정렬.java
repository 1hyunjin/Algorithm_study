import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Point[] arr = new Point[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            int num = numlist[i];
            arr[i] = new Point(num, Math.abs(n - num));
        }
        Arrays.sort(arr);
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i].num;
        }
        return answer;
    }
    public static class Point implements Comparable<Point>{
        int num;
        int dist;

        public Point(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o1) {
            if (this.dist == o1.dist) {
                return o1.num - this.num;
            }
            return this.dist - o1.dist;
        }
    }
}