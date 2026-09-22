import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            
            for (int i = 0; i < n; i++) {
                int j = i + ThreadLocalRandom.current().nextInt(n - i);
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

           
            Arrays.sort(a);

            
            long[] pref = new long[n + 1];
            for (int i = 0; i < n; i++) {
                pref[i + 1] = pref[i] + a[n - 1 - i];
            }

            long maxScore = Long.MIN_VALUE;
            int startK = (n + 1) / 2; 
            
            
            for (int k = startK; k <= n; k++) {
                long score = pref[k] - (k * c);
                if (score > maxScore) {
                    maxScore = score;
                }
            }

            sb.append(maxScore).append("\n");
        }
        System.out.print(sb);
    }
}
