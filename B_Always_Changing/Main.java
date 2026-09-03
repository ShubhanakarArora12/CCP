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

            int t0 = 0, t1 = 0; 
            int c0 = 0, c1 = 0; 

            char prev = ' ';
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    t0++;
                } else {
                    t1++;
                }

               
                if (c != prev) {
                    if (c == '0') c0++;
                    else c1++;
                    prev = c;
                }
            }

            int delta = t0 - t1;
            int maxL = -1;

          
            for (int x = -1; x <= 1; x++) {
                
                if (Math.abs(delta - x) <= 1) {
                    int r0 = -1, r1 = -1;
                    
                    if (x == 1) {
                        r1 = Math.min(c0 - 1, c1);
                        r0 = r1 + 1;
                    } else if (x == 0) {
                        r1 = Math.min(c0, c1);
                        r0 = r1;
                    } else if (x == -1) {
                        r0 = Math.min(c0, c1 - 1);
                        r1 = r0 + 1;
                    }

                    
                    if (r0 >= 0 && r1 >= 0) {
                        maxL = Math.max(maxL, r0 + r1);
                    }
                }
            }

            if (maxL == -1) {
                sb.append("-1\n");
            } else {
                sb.append(n - maxL).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
