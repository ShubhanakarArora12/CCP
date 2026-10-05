import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // High-performance I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            long[] a = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            long ans = 0;
            
            // P represents the number of symmetric outer pairs we have the capacity to evaluate
            int P = Math.min(k - 1, n - k + 1);
            
            // Greedily pick the maximal value from each symmetric flank pair
            for (int i = 1; i <= P; i++) {
                ans += Math.max(a[i], a[n - i + 1]);
            }
            
            // Unconditionally scoop the "middle" bracket if it exists
            if (n >= 2 * k - 1) {
                for (int i = k; i <= n - k + 1; i++) {
                    ans += a[i];
                }
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
