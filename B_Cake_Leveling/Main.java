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

            long currentSum = 0;
            long minHeight = Long.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                long a = Long.parseLong(st.nextToken());
                currentSum += a;
                
                
                long currentMaxHeight = currentSum / i;
                
                
                if (currentMaxHeight < minHeight) {
                    minHeight = currentMaxHeight;
                }
                
                sb.append(minHeight).append(i == n ? "" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
