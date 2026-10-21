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
            int m = Integer.parseInt(st.nextToken());

            int[] deg = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                deg[u]++;
                deg[v]++;
            }

            
            boolean hasIsolated = false;
            for (int i = 1; i <= n; i++) {
                if (deg[i] == 0) {
                    hasIsolated = true;
                    break;
                }
            }

            if (hasIsolated) {
                sb.append("Brain Melt\n");
                continue;
            }

           
            
            if (m == n - 1) {
                int centerCount = 0;
                int leafCount = 0;
                
                for (int i = 1; i <= n; i++) {
                    if (deg[i] == n - 1) {
                        centerCount++;
                    } else if (deg[i] == 1) {
                        leafCount++;
                    }
                }
                
               
                if ((centerCount == 1 && leafCount == n - 1) || (n == 2 && leafCount == 2)) {
                    sb.append("2\n");
                } else {
                    sb.append("Many\n");
                }
            } else {
                sb.append("Many\n");
            }
        }

        System.out.print(sb);
    }
}
