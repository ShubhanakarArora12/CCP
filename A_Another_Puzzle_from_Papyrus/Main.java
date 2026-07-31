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
            int c = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());

            // 1. Check direct alignment without reordering
            boolean validNoReorder = true;
            int costNoReorder = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    validNoReorder = false;
                    break;
                }
                costNoReorder += (a[i] - b[i]);
            }

            // 2. Sort both to check optimal pairing with reordering
            int[] aSorted = a.clone();
            int[] bSorted = b.clone();
            Arrays.sort(aSorted);
            Arrays.sort(bSorted);

            boolean possible = true;
            int costReorder = c; // Cost starts with reordering operation cost
            for (int i = 0; i < n; i++) {
                if (aSorted[i] < bSorted[i]) {
                    possible = false;
                    break;
                }
                costReorder += (aSorted[i] - bSorted[i]);
            }

            // 3. Determine final answer
            if (!possible) {
                sb.append("-1\n");
            } else if (validNoReorder) {
                sb.append(Math.min(costNoReorder, costReorder)).append("\n");
            } else {
                sb.append(costReorder).append("\n");
            }
        }

        System.out.print(sb);
    }
}
