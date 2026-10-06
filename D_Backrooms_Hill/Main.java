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

          
            int[] parity = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                parity[val] = i % 2; 
            }

            boolean possible = true;
            
          
            for (int i = n; i >= 2; i -= 2) {
                if (parity[i] == parity[i - 1]) {
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
