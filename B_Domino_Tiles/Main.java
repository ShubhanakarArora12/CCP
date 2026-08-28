import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

       
        String[] patterns = {
            "0011",
            "0110",
            "1001",
            "1100"
        };

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            int validCount = 0;

            
            for (String p : patterns) {
                boolean match = true;
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    
                    if (c != '?' && c != p.charAt(i % 4)) {
                        match = false;
                        break;
                    }
                }
                
                if (match) {
                    validCount++;
                }
            }

            
            sb.append(validCount).append("\n");
        }
        
        System.out.print(sb);
    }
}
