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
            
            long currentPrefixSum = 0;
            boolean possible = true;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= n; k++) {
                long val = Long.parseLong(st.nextToken());
                currentPrefixSum += val;

              
                long minRequiredSum = (long) k * (k + 1) / 2;

                if (currentPrefixSum < minRequiredSum) {
                    possible = false;
                }
            }

            if (possible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
