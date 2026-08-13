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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            int maxLen = 0;
            int currentLen = 0;

            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '#') {
                    currentLen++;
                    maxLen = Math.max(maxLen, currentLen);
                } else {
                    currentLen = 0; 
                }
            }
            if (maxLen == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append((maxLen + 1) / 2).append("\n");
            }
        }

        System.out.print(sb);
    }
}
