import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int task = 0;
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        String s = "";
        while ((s = br.readLine())!= null) {
            if (s.isEmpty()) {
                break;
            }
            if (task > 24) {
                break;
            }
            String[] sArr = s.split(" ");
            for (int i = 0; i < sArr.length; i++) {
                map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
                task++;
                total++;
            }
        }
        String[] works = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < works.length; i++) {
            String key = works[i];
            if (map.containsKey(key)) {
                double ratio = Math.round(((double)map.get(key)/total) * 100) / 100.0;
                sb.append(key).append(" ").append(map.get(key)).append(" ").append(ratio).append("\n");
            }
            else{
                sb.append(key).append(" ").append(0).append(" ").append("0.00").append("\n");
            }
        }
        sb.append("Total").append(" ").append(total).append(" ").append("1.00");
        System.out.println(sb.toString());
    }
}