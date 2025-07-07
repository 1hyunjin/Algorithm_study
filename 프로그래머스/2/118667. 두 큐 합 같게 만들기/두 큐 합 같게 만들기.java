import java.util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
       Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long total = 0;
        long sum1 = 0;
        long sum2 = 0;
        int moveCount = 0;
        long result = 0;

        for (long i : queue1) {
            q1.offer(i);
            sum1 += i;

        }
        for (long i : queue2) {
            q2.offer(i);
            sum2 += i;

        }
        
        total = sum1 + sum2;
        // 총합 홀수면 X
        if (total % 2 != 0) {
            return -1;
        }
        else {
            result = total/2;
        }
        // 최대 이동 횟수
        int maxCount = (queue1.length + queue2.length) * 2;

        while (sum1 != sum2) {

            moveCount++;

            long tmp;

            if (sum1 > sum2) {
                tmp = q1.poll();
                q2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;

            } else if (sum1 < sum2) {
                tmp = q2.poll();
                q1.offer(tmp);
                sum2 -= tmp;
                sum1 += tmp;
            }
            if (moveCount > maxCount) {
                return -1;
            }
        }
        return moveCount;
    }
}