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
            long[] w = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                w[i] = Long.parseLong(st.nextToken());
            }

            
            long[] prefMin = new long[n];
            prefMin[0] = w[0];
            for (int i = 1; i < n; i++) {
                prefMin[i] = Math.min(prefMin[i - 1], w[i]);
            }

            
            long[] suffMax = new long[n];
            suffMax[n - 1] = w[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffMax[i] = Math.max(suffMax[i + 1], w[i]);
            }

            boolean found = false;

            
            for (int m = 0; m < n - 1; m++) {
                long minLeft = prefMin[m];
                long maxRight = suffMax[m + 1];

                
                if (minLeft - maxRight >= 2) {
                    found = true;
                    break;
                }
            }

            if (found) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
