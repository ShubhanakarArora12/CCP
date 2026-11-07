import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            String a = br.readLine().trim();
            String b = br.readLine().trim();
            
            int n = a.length();
            int m = b.length();
            
            int[] pa = new int[n];
            int[] pb = new int[m];
            
            
            pa[0] = (a.charAt(0) - '0') % 10;
            for (int i = 1; i < n; i++) {
                pa[i] = (pa[i - 1] + (a.charAt(i) - '0')) % 10;
            }
            
            
            pb[0] = (b.charAt(0) - '0') % 10;
            for (int i = 1; i < m; i++) {
                pb[i] = (pb[i - 1] + (b.charAt(i) - '0')) % 10;
            }
            
         
            if (pa[n - 1] != pb[m - 1]) {
                out.append("-1\n");
                continue;
            }
            
           
            int[] dp = new int[m];
            for (int i = 0; i < n - 1; i++) {
                int prev = 0;
                for (int j = 0; j < m - 1; j++) {
                    int temp = dp[j + 1];
                    if (pa[i] == pb[j]) {
                        dp[j + 1] = prev + 1;
                    } else {
                        dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                    }
                    prev = temp;
                }
            }
            
            
            out.append(dp[m - 1] + 1).append("\n");
        }
        
        System.out.print(out);
    }
}
