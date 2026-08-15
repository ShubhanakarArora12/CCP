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
            
            if (n == 1) {
                sb.append("1\n");
            } else if (n == 2) {
                sb.append("-1\n");
            } else {
              
                sb.append("1 2");
                
                long current = 3;
                
                for (int i = 0; i < n - 2; i++) {
                    sb.append(" ").append(current);
                    current *= 2; 
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
