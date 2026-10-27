import java.io.InputStream;
import java.io.IOException;

public class Main {
    static class FastScanner {
        private InputStream in;
        private byte[] buffer = new byte[32768];
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
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
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
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int t = scanner.nextInt();
        if (t == -1) return;
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            
            int[] p = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                p[i] = scanner.nextInt();
            }
            
            int[] depth = new int[n + 1];
            int[] max_depth = new int[n + 1];
            
            depth[1] = 0;
            max_depth[1] = 0;
            for (int i = 2; i <= n; i++) {
                depth[i] = depth[p[i]] + 1;
                max_depth[i] = depth[i];
            }
            
            int[] max1 = new int[n + 1];
            int[] max2 = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                max1[i] = -1;
                max2[i] = -1;
            }
            
            
            for (int i = n; i >= 2; i--) {
                int parent = p[i];
                int d = max_depth[i];
                
                if (d > max1[parent]) {
                    max2[parent] = max1[parent];
                    max1[parent] = d;
                } else if (d > max2[parent]) {
                    max2[parent] = d;
                }
                
                if (d > max_depth[parent]) {
                    max_depth[parent] = d;
                }
            }
            
            
            long totalGuilds = n;
            for (int i = 1; i <= n; i++) {
                if (max2[i] > depth[i]) {
                    totalGuilds += (max2[i] - depth[i]);
                }
            }
            
            sb.append(totalGuilds).append("\n");
        }
        
        System.out.print(sb);
    }
}
