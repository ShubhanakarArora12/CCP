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
            int[] a = new int[n];
            int[] a_sorted = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                a_sorted[i] = a[i];
            }
            
            int[] b = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

           
            Arrays.sort(a_sorted);
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (a_sorted[i] > b[i]) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                sb.append("-1\n");
                continue;
            }

            boolean[] used = new boolean[n];
            int[] p = new int[n];

          
            for (int i = 0; i < n; i++) {
               
                int low = 0, high = n - 1;
                int L = -1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (b[mid] >= a[i]) {
                        L = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

               
                int v = L;
                while (used[v]) {
                    v++;
                }
                used[v] = true;
                p[i] = v;
            }

         
            long inv = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (p[i] > p[j]) {
                        inv++;
                    }
                }
            }
            
            sb.append(inv).append("\n");
        }
        
        System.out.print(sb);
    }
}
