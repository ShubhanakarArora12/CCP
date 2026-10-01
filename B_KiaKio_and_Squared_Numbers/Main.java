import java.io.*;
import java.util.*;

public class Main {
    
    
    static long nextVal(long x) {
        long sum = 0;
        while (x > 0) {
            long d = x % 10;
            sum += d * d;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                
               
                for (int step = 0; step < 200; step++) {
                    a[i] = nextVal(a[i]);
                }
            }
            
           
            Arrays.sort(a);
            
            long ans = 0;
            long count = 1;
            
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    count++;
                } else {
                    
                    ans += count * (count - 1) / 2;
                    count = 1;
                }
            }
            
            ans += count * (count - 1) / 2;
            
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
