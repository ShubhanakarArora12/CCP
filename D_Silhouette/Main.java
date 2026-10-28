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

        public long nextLong() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public int nextInt() throws IOException {
            return (int) nextLong();
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
            long[] b = new long[n];
            long[] bSorted = new long[n];
            
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
                bSorted[i] = b[i];
            }
            
            Arrays.sort(bSorted);
            
            long[] uniqueB = new long[n];
            int[] freq = new int[n];
            int k = 0;
            
            uniqueB[0] = bSorted[0];
            freq[0] = 1;
            
            for (int i = 1; i < n; i++) {
                if (bSorted[i] == uniqueB[k]) {
                    freq[k]++;
                } else {
                    k++;
                    uniqueB[k] = bSorted[i];
                    freq[k] = 1;
                }
            }
            k++; 
            
            boolean possible = true;
            if (uniqueB[0] != 0) {
                possible = false;
            }
            
            long[] A = new long[k];
            
            if (possible) {
                for (int i = 0; i < k - 1; i++) {
                    long diff = uniqueB[i + 1] - uniqueB[i];
                    
                    if (diff % freq[i] != 0) {
                        possible = false;
                        break;
                    }
                    
                    A[i] = diff / freq[i];
                    
                    
                    if (i > 0 && A[i] <= A[i - 1]) {
                        possible = false;
                        break;
                    }
                }
            }
            
            if (possible) {
                if (k == 1) {
                    A[0] = 1;
                } else {
                    A[k - 1] = A[k - 2] + 1;
                }
                
                for (int i = 0; i < n; i++) {
                    
                    int low = 0, high = k - 1;
                    int idx = -1;
                    while (low <= high) {
                        int mid = (low + high) >>> 1;
                        if (uniqueB[mid] == b[i]) {
                            idx = mid;
                            break;
                        } else if (uniqueB[mid] < b[i]) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    sb.append(A[idx]).append(i == n - 1 ? "" : " ");
                }
                sb.append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        
        System.out.print(sb);
    }
}
