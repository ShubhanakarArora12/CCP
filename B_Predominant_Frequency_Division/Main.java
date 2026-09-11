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

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            
            int[] P1 = new int[n + 1];
            int[] P12 = new int[n + 1];

            for (int i = 0; i < n; i++) {
                P1[i + 1] = P1[i] + (a[i] == 1 ? 1 : 0);
                P12[i + 1] = P12[i] + (a[i] <= 2 ? 1 : 0);
            }

            
            int[] M12 = new int[n + 1];
            for (int k = 1; k <= n; k++) {
                M12[k] = 2 * P12[k] - k;
            }

           
            int[] sufMax = new int[n + 1];
            sufMax[n - 1] = M12[n - 1]; 
            
            for (int j = n - 2; j >= 1; j--) {
                sufMax[j] = Math.max(sufMax[j + 1], M12[j]);
            }

            boolean possible = false;
            
         
            for (int i = 1; i <= n - 2; i++) {
                
                if (2 * P1[i] - i >= 0) {
                    
                    if (sufMax[i + 1] >= M12[i]) {
                        possible = true;
                        break;
                    }
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
