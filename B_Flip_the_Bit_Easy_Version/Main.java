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

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            
            int p1 = Integer.parseInt(st.nextToken()) - 1;
            int x = a[p1];

            
            int diff_L = 0;
            int prevL = x;
            for (int i = 0; i <= p1; i++) {
                if (a[i] != prevL) {
                    diff_L++;
                }
                prevL = a[i];
            }

            
            int diff_R = 0;
            int prevR = a[p1];
            for (int i = p1 + 1; i < n; i++) {
                if (a[i] != prevR) {
                    diff_R++;
                }
                prevR = a[i];
            }
            if (x != prevR) {
                diff_R++;
            }

           
            sb.append(Math.max(diff_L, diff_R)).append("\n");
        }

        System.out.print(sb);
    }
}
