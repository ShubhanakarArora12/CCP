import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 200005;
    static int[] spf = new int[MAX];

   
    static void precomputeSPF() {
        for (int i = 2; i < MAX; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i < MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAX; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        precomputeSPF();
        
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            
            long[] dp = new long[n + 1];

           
            for (int x = k + 1; x <= n; x++) {
                long minOps = Long.MAX_VALUE;
                int curr = x;
                
               
                while (curr > 1) {
                    int p = spf[curr];
                    
                    
                    minOps = Math.min(minOps, 1L + (long) p * dp[x / p]);
                    
                  
                    while (curr % p == 0) {
                        curr /= p;
                    }
                }
                dp[x] = minOps;
            }

            long totalOps = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int a_i = Integer.parseInt(st.nextToken());
                totalOps += dp[a_i];
            }

            sb.append(totalOps).append("\n");
        }

        System.out.print(sb);
    }
}
