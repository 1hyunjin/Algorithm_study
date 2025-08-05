import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();
        int cnt = 1; // 처음 좌석은 양옆에 컵홀더 있으니까
        int idx = 0;
        while (idx != seats.length()) {
            if (seats.charAt(idx) == 'S') {
                cnt++;
            } else if (seats.charAt(idx) == 'L') {
                if (seats.charAt(idx + 1) == 'L') {
                    cnt++;
                    idx++;
                }
            }
            idx++;
        }
        if (cnt >= seats.length()) {
            System.out.println(seats.length());
        }
        else{
            System.out.println(cnt);
        }
    }
}