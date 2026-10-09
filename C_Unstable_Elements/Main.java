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
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            
            int[] counts = new int[n + 1];
            int currentLen = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    currentLen++;
                } else {
                    counts[currentLen]++;
                    currentLen = 1;
                }
            }
            counts[currentLen]++;

            
            int[] u = new int[n + 1];
            int m = 0;
            for (int i = 1; i <= n; i++) {
                if (counts[i] > 0) {
                    u[++m] = i; 
                }
            }

            int ans = 0;
            long C = 0;
            long S = 0;

           
            for (int j = m - 1; j >= 0; j--) {
                int nextU = u[j + 1]; 
                
                
                C += counts[nextU];
                S += (long) nextU * counts[nextU];

                long diff = k - S;
                
              
                if (diff % C == 0) {
                    long x = diff / C;
                    
                   
                    if (x >= 1 - nextU) {
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
