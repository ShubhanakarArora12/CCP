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
            String s = br.readLine().trim();

            
            int L = 1;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    L++;
                }
            }

            int maxReduction = 0;
            
          
            for (int i = 1; i < n - 1; i++) {
                char prev = s.charAt(i - 1);
                char curr = s.charAt(i);
                char next = s.charAt(i + 1);

               
                if (curr != prev && curr != next) {
                    if (prev == next) {
                        maxReduction = Math.max(maxReduction, 2); 
                    } else {
                        maxReduction = Math.max(maxReduction, 1); 
                    }
                }
            }

            
            sb.append(L - maxReduction).append("\n");
        }

        System.out.print(sb);
    }
}
