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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken()); // k is logically bypassed

            String s = br.readLine().trim();
            int len = 2 * n;
            char[] next_s = s.toCharArray();

            
            for (int i = 0; i < len; i++) {
                int next_i = (i + 1) % len;
                if (s.charAt(i) == '1' && s.charAt(next_i) == '0') {
                    next_s[i] = '0';
                    next_s[next_i] = '1';
                }
            }

            int redScore = 0;
            int blueScore = 0;

            for (int i = 0; i < len; i++) {
                if (next_s[i] == '1') {
                   
                    if (i % 2 != 0) {
                        redScore++;
                    } else {
                        blueScore++;
                    }
                }
            }

            sb.append(redScore).append(" ").append(blueScore).append("\n");
        }

        System.out.print(sb);
    }
}
