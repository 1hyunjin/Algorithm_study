import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int choice = (X - 1000 * N) / 4000;

        Point[] arr = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        int sum = 0;

        for (int i = 0; i < choice; i++) {
            if (arr[i].menu1 < arr[i].menu2) {
                sum+=arr[i].menu2;
            }
            else {
                sum += arr[i].menu1;
            }
        }
        for (int i = choice; i < N; i++) {
            sum += arr[i].menu2;
        }

        System.out.println(sum);
    }

    public static class Point implements Comparable<Point> {
        int menu1;
        int menu2;

        public Point(int menu1, int menu2) {
            this.menu1 = menu1;
            this.menu2 = menu2;
        }

        @Override
        public int compareTo(Point o) {
            return (o.menu1 - o.menu2) - (this.menu1 - this.menu2);
        }
    }
}
