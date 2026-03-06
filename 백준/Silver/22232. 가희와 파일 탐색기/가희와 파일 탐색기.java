import java.io.*;
import java.util.*;

class Main {
    static Set<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        File[] files = new File[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] arr = s.split("\\.");
            File file = new File(arr[0], arr[1]);
            files[i] = file;
        }
        set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set.add(br.readLine());
        }
        Arrays.sort(files);
        StringBuilder sb = new StringBuilder();
        for (File file : files) {
            sb.append(file.name).append(".").append(file.extension);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    public static class File implements Comparable<File>{
        String name;
        String extension;

        public File(String name, String extension) {
            this.name = name;
            this.extension = extension;
        }

        @Override
        public int compareTo(File o) {
            if (this.name.equals(o.name)) {
                boolean a = set.contains(this.extension);
                boolean b = set.contains(o.extension);
                if(a && !b) return -1;
                if(!a && b) return 1;

                return this.extension.compareTo(o.extension);
            }
            return this.name.compareTo(o.name);
        }
    }
}