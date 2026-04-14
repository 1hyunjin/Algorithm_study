import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            Map<String, String> map = new HashMap<>();
            while (true) {
                String q = br.readLine();
                if (q.equals("what does the fox say?")) {
                    break;
                }
                String[] arr = q.split(" ");
                map.put(arr[2], arr[0]);
            }
            String[] sounds = s.split(" ");
            for (int i = 0; i < sounds.length; i++) {
                String sound = sounds[i];
                if (!map.containsKey(sound)) {
                    sb.append(sound).append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}