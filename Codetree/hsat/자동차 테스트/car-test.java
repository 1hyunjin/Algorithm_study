import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextInt();
        // Please write your code here.
        Arrays.sort(a);
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            long left = i;
            long right = n-i-1L;
            map.put(a[i], left*right);
        } 
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < queries.length; i++){
            int val = queries[i];
            if(map.containsKey(val)){
                sb.append(map.get(val)).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}