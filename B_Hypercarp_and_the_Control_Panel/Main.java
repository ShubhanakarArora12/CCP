import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int TestsNumT = Integer.parseInt(line.trim());

        while (TestsNumT-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] colors = new int[n];
            int[] counts = new int[n];
            int m = 0;

            for (int i = 0; i < n; i++) {
                if (m == 0 || colors[m - 1] != a[i]) {
                    colors[m] = a[i];
                    counts[m] = 1;
                    m++;
                } else {
                    counts[m - 1]++;
                }
            }

            int ans = m;
            boolean canAdd = false;

            for (int i = 0; i < m; i++) {
                if (counts[i] >= 2) {
                    if (i + 1 < m && (i + 2 >= m || colors[i] != colors[i + 2])) {
                        canAdd = true;
                        break;
                    }
                    if (i - 1 >= 0 && (i - 2 < 0 || colors[i] != colors[i - 2])) {
                        canAdd = true;
                        break;
                    }
                }
            }

            if (canAdd) {
                ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
