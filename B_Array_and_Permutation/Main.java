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
            
            int[] p = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

          
            int[] aPrime = new int[n];
            int k = 0;
            boolean[] seen = new boolean[n + 1];
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (i == 0 || a[i] != a[i - 1]) {
                  
                    if (seen[a[i]]) {
                        possible = false;
                        break;
                    }
                    seen[a[i]] = true;
                    aPrime[k++] = a[i];
                }
            }

            if (!possible) {
                sb.append("NO\n");
                continue;
            }

           
            int idxA = 0;
            int idxP = 0;
            
            while (idxA < k && idxP < n) {
                if (aPrime[idxA] == p[idxP]) {
                    idxA++;
                }
                idxP++;
            }

           
            if (idxA == k) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}
