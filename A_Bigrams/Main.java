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
            int k = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int countGte3 = 0;
            int countGte2 = 0;

            for (int i = 0; i < k; i++) {
                long c = Long.parseLong(st.nextToken());
                if (c >= 3) countGte3++;
                if (c >= 2) countGte2++;
            }

            if (countGte3 >= 1 || countGte2 >= 2) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
