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

            int[] l = new int[n + 1];
            int[] r = new int[n + 1];
            int[] u = new int[n + 1];
            int[] v = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                l[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
                u[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            
            for (int m = n; m >= 1; m--) {
                int pos = 1;
                int j = 1;   

                while (j <= m && pos <= n) {
                    int rightRank = m - j + 1;
                    
                  
                    boolean leftValid = j < l[pos] || j > r[pos];
                    boolean rightValid = rightRank < u[pos] || rightRank > v[pos];

                    if (leftValid && rightValid) {
                        j++; 
                    }
                    pos++; 
                }

               
                if (j > m) {
                    ans = m;
                    break;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
