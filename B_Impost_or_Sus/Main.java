import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String r = br.readLine().trim();
            int n = r.length();
            char[] s = r.toCharArray();
            
            int ops = 0;
            
           
            if (s[0] == 'u') {
                s[0] = 's';
                ops++;
            }
            if (s[n - 1] == 'u') {
                s[n - 1] = 's';
                ops++;
            }
            
           
            int uCount = 0;
            for (int i = 1; i < n - 1; i++) {
                if (s[i] == 'u') {
                    uCount++;
                } else {
                    
                    ops += uCount / 2;
                    uCount = 0;
                }
            }
            
            ops += uCount / 2;

            sb.append(ops).append("\n");
        }
        
        System.out.print(sb);
    }
}
