import java.io.*;
import java.util.*;

public class Main {
    
  
    static int getOddBase(int x) {
        return x >> Integer.numberOfTrailingZeros(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean possible = true;
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                
               
                if (possible) {
                    if (getOddBase(i) != getOddBase(val)) {
                        possible = false;
                    }
                }
            }

            if (possible) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}
