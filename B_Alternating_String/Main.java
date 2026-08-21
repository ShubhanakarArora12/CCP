import java.io.*;

public class Main {

    static boolean canTransformTo(String s, String target) {
        int n = s.length();
        int firstMismatch = -1;
        int lastMismatch = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != target.charAt(i)) {
                if (firstMismatch == -1) firstMismatch = i;
                lastMismatch = i;
            }
        }

        
        if (firstMismatch == -1) return true;

        int l = firstMismatch;
        int r = lastMismatch;

      
        boolean modeAValid = true;
        for (int i = 0; i <= r - l; i++) {
            if (s.charAt(r - i) != target.charAt(l + i)) {
                modeAValid = false;
                break;
            }
        }
        if (modeAValid) return true;

        // Mode B: Invert and Reverse
        boolean modeBValid = true;
        for (int i = 0; i <= r - l; i++) {
            char orig = s.charAt(r - i);
            char inverted = (orig == 'a') ? 'b' : 'a';
            if (inverted != target.charAt(l + i)) {
                modeBValid = false;
                break;
            }
        }
        return modeBValid;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();

          
            StringBuilder t1 = new StringBuilder(n);
           
            StringBuilder t2 = new StringBuilder(n);

            for (int i = 0; i < n; i++) {
                t1.append(i % 2 == 0 ? 'a' : 'b');
                t2.append(i % 2 == 0 ? 'b' : 'a');
            }

            if (canTransformTo(s, t1.toString()) || canTransformTo(s, t2.toString())) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
