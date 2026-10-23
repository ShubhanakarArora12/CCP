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
            
            
            int m = 1;
            while (m <= n) {
                m <<= 1;
            }
            
           
            sb.append((2 * m - 1)).append("\n");
            
            int prevP = 0;
            
            
            for (int i = 1; i < m; i++) {
                int currP = i ^ (i >> 1);
                sb.append(currP ^ prevP).append(" ");
                prevP = currP;
            }
            
            
            sb.append(0).append(" ");
            
           
            for (int i = m - 2; i >= 0; i--) {
                int currP = i ^ (i >> 1);
                sb.append(currP ^ prevP).append(" ");
                prevP = currP;
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
