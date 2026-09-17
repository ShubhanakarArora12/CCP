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
            int m = Integer.parseInt(st.nextToken());

            int[] O = new int[n];
            int[] E = new int[n];
            int oSize = 0;
            int eSize = 0;
            long totalSum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                totalSum += val;
                // 1-based indexing for odd/even split
                if (i % 2 != 0) {
                    O[oSize++] = val;
                } else {
                    E[eSize++] = val;
                }
            }

            int cOdd = 0;
            int cEven = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x % 2 != 0) {
                    cOdd++;
                } else {
                    cEven++;
                }
            }

           
            Arrays.sort(O, 0, oSize);
            Arrays.sort(E, 0, eSize);

            long markedSum = 0;

            if (cOdd > 0 && oSize > 0) {
                
                int idx = oSize - 1;
                markedSum += O[idx--];
                
                int limit = Math.min(oSize, cOdd);
                for (int i = 1; i < limit; i++) {
                 
                    if (O[idx] > 0) {
                        markedSum += O[idx];
                    }
                    idx--;
                }
            }

            if (cEven > 0 && eSize > 0) {
               
                int idx = eSize - 1;
                markedSum += E[idx--];
                
                int limit = Math.min(eSize, cEven);
                for (int i = 1; i < limit; i++) {
                    if (E[idx] > 0) {
                        markedSum += E[idx];
                    }
                    idx--;
                }
            }

           
            sb.append(totalSum - markedSum).append("\n");
        }
        
        System.out.print(sb);
    }
}
