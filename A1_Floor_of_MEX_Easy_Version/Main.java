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
            StringTokenizer st = new StringTokenizer(br.readLine());

           
            int[] diff = new int[n + 1];

            for (int k = 1; k <= n; k++) {
                long ak = Long.parseLong(st.nextToken());
                long L = ak * k;
                long R = (ak + 1) * k - 1;

                if (L < n) {
                    int left = (int) L;
                    int right = (int) Math.min(n - 1, R);
                    diff[left]++;
                    diff[right + 1]--;
                }
            }

            
            int[] b = new int[n];
            int m = 0;
            int activeForbidden = 0;

            for (int y = 0; y < n; y++) {
                activeForbidden += diff[y];
                if (activeForbidden == 0) {
                    b[m++] = y;
                }
            }

            sb.append(m).append("\n");
            for (int i = 0; i < m; i++) {
                sb.append(b[i]).append(i == m - 1 ? "" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
