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

         
            if (k >= n - 1) {
                sb.append("-1\n");
                continue;
            }

            int b = n - k; 
            int rem0 = (n + 1) / 2; 
            int rem1 = n / 2;       

            
            int last0 = (b % 2 != 0) ? b - 1 : b - 2;
            int last1 = (b % 2 != 0) ? b - 2 : b - 1;

            char[] ans = new char[n];
            int idx = 0;

            for (int i = 0; i < b; i++) {
                int len;
                if (i % 2 == 0) { 
                    len = (i == last0) ? rem0 : 1;
                    rem0 -= len;
                    for (int j = 0; j < len; j++) {
                        ans[idx++] = '0';
                    }
                } else {
                    len = (i == last1) ? rem1 : 1;
                    rem1 -= len;
                    for (int j = 0; j < len; j++) {
                        ans[idx++] = '1';
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
}
