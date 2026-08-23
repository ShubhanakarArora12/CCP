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
            int[] p = new int[n + 1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            
            
            int[] P = new int[n + 1];
            
            
            int[] diff = new int[n + 3]; 
            
            for (int k = 1; k <= n; k++) {
                P[k] = P[k - 1];
                if (p[k] <= k) {
                    P[k]++;
                } else {
                    
                    diff[k + 1]++;
                    diff[p[k] + 1]--;
                }
            }
            
            int maxChairs = 0;
            int activeIntervals = 0;
            
            
            for (int E = 1; E <= n + 1; E++) {
                activeIntervals += diff[E];
                
                
                int currentScore = P[E - 1] + activeIntervals;
                
                if (currentScore > maxChairs) {
                    maxChairs = currentScore;
                }
            }
            
            sb.append(maxChairs).append("\n");
        }
        
        System.out.print(sb);
    }
}
