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
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;
            int prev = Integer.parseInt(st.nextToken());

            for (int i = 1; i < n; i++) {
                int curr = Integer.parseInt(st.nextToken());
                int diff = Math.abs(curr - prev);
                
             
                if (curr % diff == 0) {
                    count++;
                }
                prev = curr;
            }
            
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
