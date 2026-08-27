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
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

           
            if (a[0] == -1 && a[n - 1] == -1) {
                a[0] = 0;
                a[n - 1] = 0;
            } else if (a[0] == -1) {
                a[0] = a[n - 1];
            } else if (a[n - 1] == -1) {
                a[n - 1] = a[0];
            }

            
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == -1) {
                    a[i] = 0;
                }
            }

            // Output the minimum absolute sum
            long minSum = Math.abs(a[n - 1] - a[0]);
            sb.append(minSum).append("\n");
            
            // Output the reconstructed array
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(i == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
