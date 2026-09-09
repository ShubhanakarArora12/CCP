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
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            
            long totalTransferredValue = 0;

            
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                totalTransferredValue += (a[i] / x) * y;
            }

            long maxMoney = 0;
            
           
            for (int i = 0; i < n; i++) {
                
                long currentMoney = a[i] - ((a[i] / x) * y) + totalTransferredValue;
                if (currentMoney > maxMoney) {
                    maxMoney = currentMoney;
                }
            }

            sb.append(maxMoney).append("\n");
        }
        
        System.out.print(sb);
    }
}
