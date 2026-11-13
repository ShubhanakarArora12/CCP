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

    static int[] parent;

    static int find(int i) {
        int root = i;
        while (root != parent[root]) {
            root = parent[root];
        }
        int curr = i;
        while (curr != root) {
            int nxt = parent[curr];
            parent[curr] = root;
            curr = nxt;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] b = new long[n];
            long totalSum = 0;

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
                totalSum += b[i];
            }

            
            if (totalSum < 1) {
                sb.append("-1\n");
                continue;
            }

            Arrays.sort(b);

           
            int uniqueCount = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0 || b[i] != b[i - 1]) {
                    uniqueCount++;
                }
            }

            long[] vals = new long[uniqueCount];
            int[] counts = new int[uniqueCount];
            parent = new int[uniqueCount + 1]; 
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (i == 0 || b[i] != b[i - 1]) {
                    idx++;
                    vals[idx] = b[i];
                }
                counts[idx]++;
            }

            for (int i = 0; i <= uniqueCount; i++) {
                parent[i] = i;
            }

            long curr = 0;
            boolean possible = true;
            long[] a = new long[n];

           
            for (int i = 0; i < n; i++) {
                long target = 1 - curr;
                int pos = Arrays.binarySearch(vals, target);
                
                if (pos < 0) {
                    pos = -(pos + 1);
                }

                pos = find(pos);

                if (pos == uniqueCount) {
                    possible = false;
                    break;
                }

                curr += vals[pos];
                a[i] = curr;
                
                counts[pos]--;
                if (counts[pos] == 0) {
                    parent[pos] = find(pos + 1);
                }
            }

            if (!possible) {
                sb.append("-1\n");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(a[i]).append(i == n - 1 ? "" : " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
