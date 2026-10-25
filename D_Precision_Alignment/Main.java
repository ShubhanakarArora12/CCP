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

        public long nextLong() throws IOException {
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
            long res = 0;
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
        StringBuilder sb = new StringBuilder();
        
        long t = sc.nextLong();
        if (t == -1) return;
        
        while (t-- > 0) {
            int n = (int) sc.nextLong();
            long k = sc.nextLong();
            
            long[] S = new long[n];
            long[] U = new long[n];
            long low = Long.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();
                
                S[i] = a + b + c;
                low = Math.min(low, S[i]);
                
                
                if (a <= b && b <= c) {
                    if (a == c) {
                        U[i] = -1; 
                    } else {
                        U[i] = Math.min(b - a, c - b) + 1;
                    }
                } else {
                    U[i] = 0; 
                }
            }
            
            long high = low + k;
            
           
            for (int i = 0; i < n; i++) {
                if (U[i] == -1) {
                    high = Math.min(high, S[i]);
                }
            }
            
            long ans = low;
            
           
            while (low <= high) {
                long mid = low + (high - low) / 2;
                
                if (canAchieveTarget(mid, S, U, k)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean canAchieveTarget(long target, long[] S, long[] U, long k) {
        long req = 0;
        for (int i = 0; i < S.length; i++) {
            if (target <= S[i]) continue; 
            
            if (U[i] == -1) return false; 
            
            
            req += (target - S[i]) + 2 * U[i];
            
           
            if (req > k) return false; 
        }
        return req <= k;
    }
}
