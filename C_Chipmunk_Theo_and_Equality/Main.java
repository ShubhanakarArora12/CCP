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
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            
            long[] cands = new long[150]; 
            int numCands = 0;
            long curr = a[0];
            boolean hit1 = false, hit2 = false;

            while (true) {
                if (curr == 1) {
                    if (hit1) break;
                    hit1 = true;
                } else if (curr == 2) {
                    if (hit2) break;
                    hit2 = true;
                }
                
                cands[numCands++] = curr;
                
                if (curr % 2 == 0) curr /= 2;
                else curr += 1;
            }

            
            long[] sortedCands = Arrays.copyOf(cands, numCands);
            Arrays.sort(sortedCands);

            long[] cost = new long[numCands];
            int[] count = new int[numCands];

            
            for (int i = 0; i < n; i++) {
                curr = a[i];
                int d = 0;
                hit1 = false;
                hit2 = false;
                boolean[] hit = new boolean[numCands];

                while (true) {
                    if (curr == 1) {
                        if (hit1) break;
                        hit1 = true;
                    } else if (curr == 2) {
                        if (hit2) break;
                        hit2 = true;
                    }

                    int idx = Arrays.binarySearch(sortedCands, curr);
                    
                    
                    if (idx >= 0 && !hit[idx]) {
                        hit[idx] = true;
                        cost[idx] += d;
                        count[idx]++;
                    }

                    if (curr % 2 == 0) curr /= 2;
                    else curr += 1;
                    d++;
                }
            }

            
            long minOps = Long.MAX_VALUE;
            for (int j = 0; j < numCands; j++) {
                if (count[j] == n) {
                    minOps = Math.min(minOps, cost[j]);
                }
            }
            
            sb.append(minOps).append("\n");
        }
        System.out.print(sb);
    }
}
