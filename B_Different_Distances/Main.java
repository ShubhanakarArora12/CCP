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
            int[] ans = new int[4 * n];
            int idx = 0;

            
            for (int i = 1; i <= n; i++) {
                ans[idx++] = i;
            }

            
            for (int i = n; i >= 1; i--) {
                int val = i;
                if (n % 2 != 0) {
                    int m = (n + 1) / 2;
                    if (val == m) {
                        val = m + 1;
                    } else if (val == m + 1) {
                        val = m;
                    }
                }
                ans[idx++] = val;
            }

           
            for (int i = 1; i <= n; i++) {
                ans[idx++] = i;
            }

            
            for (int i = 1; i <= n; i++) {
                ans[idx++] = i;
            }

           
            for (int i = 0; i < 4 * n; i++) {
                sb.append(ans[i]).append(i == 4 * n - 1 ? "" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
