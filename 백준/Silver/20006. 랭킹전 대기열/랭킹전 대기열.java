import java.io.*;
import java.util.*;

class Main {
    static int p, m, idx;
    static List<Room> rooms;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(i == 0){   // 방이 없을 때
                makeRoom(level, name);
            }
            else{
                boolean isEnter = false;
                for (int j = 0; j < rooms.size(); j++) {
                    Room cur = rooms.get(j);
                    if(cur.cnt < m && (cur.level+10 >= level && cur.level-10 <= level)){
                        isEnter = true;
                        cur.map.put(name, level);
                        cur.cnt++;
                        break;
                    }
                }
                if (!isEnter) {
                    makeRoom(level, name);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            if (room.cnt == m) {
                sb.append("Started!").append("\n");
            }
            else{
                sb.append("Waiting!").append("\n");
            }
            for (String name : room.map.keySet()) {
                sb.append(room.map.get(name)).append(" ").append(name).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void makeRoom(int level, String name) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put(name, level);
        rooms.add(new Room(level, map, 1));
    }

    public static class Room{
        int level;
        TreeMap<String, Integer> map;
        int cnt;

        public Room(int level, TreeMap<String, Integer> map, int cnt) {
            this.level = level;
            this.map = map;
            this.cnt = cnt;
        }
    }
}