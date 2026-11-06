import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

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
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt(); // q = 0 in Easy Version
            
            int[] a = new int[n];
            int[] S = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                S[i] = a[i];
            }
            
            Arrays.sort(S);
            
            
            int[] distinct = new int[n];
            int D = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || S[i] != S[i - 1]) {
                    distinct[D++] = S[i];
                }
            }
            
           
            int[] freq = new int[D];
            int nonZeroCount = 0;
            int max_tz = -1;
            
            for (int i = 1; i < n; i++) {
                
                int idA = Arrays.binarySearch(distinct, 0, D, a[i - 1]);
                if (freq[idA] == 0) nonZeroCount++;
                freq[idA]++;
                if (freq[idA] == 0) nonZeroCount--;
                
                
                int idS = Arrays.binarySearch(distinct, 0, D, S[i - 1]);
                if (freq[idS] == 0) nonZeroCount++;
                freq[idS]--;
                if (freq[idS] == 0) nonZeroCount--;
                
               
                if (nonZeroCount > 0) {
                    int tz = Integer.numberOfTrailingZeros(i);
                    if (tz > max_tz) {
                        max_tz = tz;
                    }
                }
            }
            
            
            if (max_tz == -1) {
                sb.append(0).append("\n");
            } else {
                sb.append(1 << max_tz).append("\n");
            }
        }
        System.out.print(sb);
    }
}
