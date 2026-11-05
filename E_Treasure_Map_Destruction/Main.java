import java.io.InputStream;
import java.io.IOException;

public class Main {
  
    static class FastScanner {
        private InputStream in;
        private byte[] buffer = new byte[1024 * 64];
        private int head = 0;
        private int tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res * sign;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder output = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            
            int[] diff = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (b[i] > 0) {
                    
                    int L = Math.max(0, i - b[i] + 1);
                    int R = Math.min(n - 1, i + b[i] - 1);
                    if (L <= R) {
                        diff[L]++;
                        diff[R + 1]--;
                    }
                }
            }

            
            boolean[] can_treasure = new boolean[n];
            int current = 0;
            for (int i = 0; i < n; i++) {
                current += diff[i];
                can_treasure[i] = (current == 0);
            }

            
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (b[i] != -1) {
                    boolean left_valid = (i - b[i] >= 0) && can_treasure[i - b[i]];
                    boolean right_valid = (i + b[i] < n) && can_treasure[i + b[i]];
                    
                    
                    if (!left_valid && !right_valid) {
                        possible = false;
                        break;
                    }
                }
            }

            if (!possible) {
                output.append("-1\n");
            } else {
                StringBuilder treasure_map_fin = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    treasure_map_fin.append(can_treasure[i] ? '1' : '0');
                }
                output.append(treasure_map_fin).append("\n");
            }
        }
        System.out.print(output);
    }
}
