import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length; i++){
            map.put(t[i], i);   // 몇 번째 위치인지 확인
        }
        int[] cnt = new int[26];

        for (char c : s) {
            if(!map.containsKey(c)) continue;

            int idx = map.get(c); // t에서의 위치 인덱스
            int cur = c - 'a';

            if (idx == 0) {
                cnt[cur]++;
            }
            else{
                int prev = t[idx-1] - 'a';
                if (cnt[cur] < cnt[prev]) {
                    cnt[cur]++;
                }
            }
        }
        char last = t[t.length - 1];
        System.out.println(cnt[last - 'a']);
    }
}