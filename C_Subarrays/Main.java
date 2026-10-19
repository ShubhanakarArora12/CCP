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
            int k = scanner.nextInt();
            
           
            int[] P = new int[n + 1];
            long currentSum = 0;
            P[0] = 0;
            
            for (int i = 1; i <= n; i++) {
                int a = scanner.nextInt();
                currentSum = (currentSum + a) % k;
                P[i] = (int) currentSum;
            }
            
            long ans = 0;
            int[] count = new int[k];
            
            
            for (int r = k + 1; r <= n; r++) {
                
                int valid_j = r - k - 1;
                count[P[valid_j]]++;
                
                ans += count[P[r]];
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
