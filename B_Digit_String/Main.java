import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();
            int totalOdds = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '1' || c == '3') {
                    totalOdds++;
                }
            }
            
          int maxValidLength = totalOdds; 
            int current2s = 0;
            int currentOdds = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                
                if (c == '2') {
                    current2s++;
                } else if (c == '1' || c == '3') {
                    currentOdds++;
                }
                int possibleLength = current2s + (totalOdds - currentOdds);
                if (possibleLength > maxValidLength) {
                    maxValidLength = possibleLength;
                }
            }
          sb.append(n - maxValidLength).append("\n");
        }
        
        System.out.print(sb);
    }
}
