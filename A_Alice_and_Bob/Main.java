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
            long a = Long.parseLong(st.nextToken());

            long[] v = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Long.parseLong(st.nextToken());
            }

            
            int low = 0, high = n - 1;
            int firstGE = n; 
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (v[mid] >= a) {
                    firstGE = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int lessCount = firstGE;

           
            low = 0; high = n - 1;
            int firstG = n; 
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (v[mid] > a) {
                    firstG = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            int greaterCount = n - firstG;

           
            if (greaterCount > lessCount) {
                sb.append(a + 1).append("\n");
            } else {
                sb.append(a - 1).append("\n");
            }
        }
        
        
        System.out.print(sb);
    }
}
