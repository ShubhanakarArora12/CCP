import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            if (n == 1) {
               
                sb.append(s1.charAt(0) == s2.charAt(0) ? 0 : 1).append("\n");
                continue;
            }

           
            int dp_prev2 = 0;
            int dp_prev1 = (s1.charAt(0) == s2.charAt(0)) ? 0 : 1;

            for (int i = 1; i < n; i++) {
               
                int costV = (s1.charAt(i) == s2.charAt(i)) ? 0 : 1;
                
                
                int costH = ((s1.charAt(i - 1) == s1.charAt(i)) ? 0 : 1) + 
                            ((s2.charAt(i - 1) == s2.charAt(i)) ? 0 : 1);
                
                int dp_curr = Math.min(dp_prev1 + costV, dp_prev2 + costH);
                
                
                dp_prev2 = dp_prev1;
                dp_prev1 = dp_curr;
            }
            
            sb.append(dp_prev1).append("\n");
        }
        
        System.out.print(sb);
    }
}
