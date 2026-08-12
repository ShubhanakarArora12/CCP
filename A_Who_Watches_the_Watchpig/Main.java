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
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine().trim();

            
            if (2 * k > n) {
                sb.append("-1\n");
            } else {
                int flips = 0;
                
               
                for (int i = 0; i < k; i++) {
                    if (s.charAt(i) == 'L') {
                        flips++;
                    }
                }
                
               
                for (int i = n - k; i < n; i++) {
                    if (s.charAt(i) == 'R') {
                        flips++;
                    }
                }
                
                sb.append(flips).append("\n");
            }
        }

        System.out.print(sb);
    }
}
