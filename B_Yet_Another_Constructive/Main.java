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
            int k = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            if (k > m) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
                long specialVal = m - k + 1;

                for (int i = 1; i <= n; i++) {
                    if (i % k == 0) {
                        sb.append(specialVal);
                    } else {
                        sb.append(1);
                    }
                    sb.append(i == n ? "" : " ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
