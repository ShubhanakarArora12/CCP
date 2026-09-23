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
            int[] a = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            List<Integer> drops = new ArrayList<>();
            int maxDrop = 0;
            
            
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    drops.add(i);
                    maxDrop = Math.max(maxDrop, a[i] - a[i + 1]);
                }
            }
            
           
            if (drops.isEmpty()) {
                sb.append("YES\n");
                continue;
            }
            
            boolean possible = true;
            
          
            for (int k = 0; k < drops.size() - 1; k++) {
                int start = drops.get(k);
                int end = drops.get(k + 1);
                
                boolean foundRecovery = false;
                for (int j = start + 1; j < end; j++) {
                    if (a[j + 1] - a[j] >= maxDrop) {
                        foundRecovery = true;
                        break;
                    }
                }
                
                if (!foundRecovery) {
                    possible = false;
                    break;
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
