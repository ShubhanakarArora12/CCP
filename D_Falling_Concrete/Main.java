import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

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
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int t = scanner.nextInt();
        if (t == -1) return;
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            
           
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                b[i] = a - (i + 1);
            }
            
            
            Arrays.sort(b);
            int ballast = 0;
            
            int maxLen = 1;
            int curLen = 1;
            
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {
                    
                    continue;
                } else if (b[i] == b[i - 1] + 1) {
                   
                    curLen++;
                    maxLen = Math.max(maxLen, curLen);
                } else {
                   
                    curLen = 1;
                }
            }
            
            out.append(maxLen).append("\n");
        }
        
        System.out.print(out);
    }
}
