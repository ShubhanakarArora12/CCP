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
            long x1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if (n <= 3) {
               
                sb.append(1).append("\n");
            } else {
               
                long d = Math.abs(x1 - x2);
                d = Math.min(d, n - d);
                
                
            }
        }
        
        System.out.print(sb);
    }
}
