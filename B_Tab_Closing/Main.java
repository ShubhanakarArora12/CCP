import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());

         
            if (b == a || b * n <= a) {
                sb.append(1).append("\n");
            } else {
                sb.append(2).append("\n");
            }
        }

        System.out.print(sb);
    }
}
