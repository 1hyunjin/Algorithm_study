import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];
        int[] score = new int[N];
        Arrays.fill(score, 1);
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Point(w, h);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
                    score[i]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static class Point {
        int weight;
        int height;

        public Point(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}