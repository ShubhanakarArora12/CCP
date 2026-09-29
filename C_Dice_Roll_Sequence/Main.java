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

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int ops = 0;
            for (int i = 1; i < n; i++) {
              
                if (a[i] == a[i - 1] || a[i] + a[i - 1] == 7) {
                    ops++;
                   
                    i++;
                }
            }

            sb.append(ops).append("\n");
        }

        System.out.print(sb);
    }
}
