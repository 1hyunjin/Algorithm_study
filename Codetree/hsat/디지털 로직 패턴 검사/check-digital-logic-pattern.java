import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map = new HashMap<>();
        long p = 0;
        for(int i = 0; i < K; i++){
            p = (p << 1);
            p = p + (s.charAt(i)-'0');
        }
        map.put(p, 1);
        // System.out.println(p);
        for(int i = K; i < s.length(); i++){
            long oldBit = (s.charAt(i-K)-'0') * (1L << K);
            long newBit = s.charAt(i)-'0';

            p = (p << 1); // 왼쪽으로 1칸 밀고
            p -= oldBit;
            p += newBit;
            map.put(p, map.getOrDefault(p,0)+1);
        }
        boolean flag = false;
        for(Long key : map.keySet()){
            if(map.get(key) >= M){
                flag = true;
                break;
            }
        }
        System.out.println(flag ? 1 : 0);
    }
}