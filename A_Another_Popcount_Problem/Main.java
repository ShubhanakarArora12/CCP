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
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long totalPopcount = 0;
            long weight = 1;

           
            while (n > 0 && weight <= n) {
                long take = Math.min(k, n / weight);
                totalPopcount += take;
                n -= take * weight;
                weight *= 2;
            }

            sb.append(totalPopcount).append("\n");
        }

        System.out.print(sb);
    }
}
