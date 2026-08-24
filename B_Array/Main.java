import java.io.*;
import java.util.*;

public class Main {
    
    static long floorDiv2(long sum) {
        if (sum >= 0) return sum / 2;
        else return (sum - 1) / 2;
    }
    
    
    static long ceilDiv2(long sum) {
        if (sum >= 0) return (sum + 1) / 2;
        else return sum / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            long[] events = new long[n]; 
            
            for (int i = 0; i < n; i++) {
                int m = 0;             
                int total_less = 0;    
                
                for (int j = i + 1; j < n; j++) {
                    if (a[j] > a[i]) {
                        long key = floorDiv2(a[i] + a[j]) + 1;
                        long shiftedKey = key + 3_000_000_000L;    
                        events[m++] = (shiftedKey << 2) | 1;       
                        
                    } else if (a[j] < a[i]) {
                        total_less++;
                        long key = ceilDiv2(a[i] + a[j]);          
                        long shiftedKey = key + 3_000_000_000L;
                        events[m++] = (shiftedKey << 2) | 0;       
                    }
                }
                
                
                Arrays.sort(events, 0, m);
                
                int maxScore = total_less;
                int currentScore = total_less;
                
                
                for (int k = 0; k < m; ) {
                    long currentKey = events[k] >> 2;
                    
                    
                    while (k < m && (events[k] >> 2) == currentKey) {
                        int val = (events[k] & 1) == 1 ? 1 : -1;
                        currentScore += val;
                        k++;
                    }
                    if (currentScore > maxScore) {
                        maxScore = currentScore;
                    }
                }
                
                sb.append(maxScore).append(i == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
