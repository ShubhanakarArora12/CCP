import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static final int MAXA = 1000000;
    static boolean[] isSquare = new boolean[MAXA + 1];

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
        for (int i = 1; i * i <= MAXA; i++) {
            isSquare[i * i] = true;
        }

        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            int[] head = new int[n + 1];
            Arrays.fill(head, -1);
            int[] to = new int[2 * n];
            int[] next = new int[2 * n];
            int edgeIdx = 0;

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                to[edgeIdx] = v;
                next[edgeIdx] = head[u];
                head[u] = edgeIdx++;

                to[edgeIdx] = u;
                next[edgeIdx] = head[v];
                head[v] = edgeIdx++;
            }

            
            int[] parent = new int[n + 1];
            int[] order = new int[n];
            int qHead = 0, qTail = 0;
            order[qTail++] = 1;
            parent[1] = 0;

            while (qHead < qTail) {
                int u = order[qHead++];
                for (int e = head[u]; e != -1; e = next[e]) {
                    int v = to[e];
                    if (v != parent[u]) {
                        parent[v] = u;
                        order[qTail++] = v;
                    }
                }
            }

            
            int[] subSize = new int[n + 1];
            Arrays.fill(subSize, 1);
            for (int i = n - 1; i >= 1; i--) {
                int u = order[i];
                subSize[parent[u]] += subSize[u];
            }

            long ans = 0;
            for (int c = 1; c <= n; c++) {
                if (!isSquare[a[c]]) continue;

                long sum1 = 0;
                long sum2 = 0;
                long sum3 = 0;

                for (int e = head[c]; e != -1; e = next[e]) {
                    int v = to[e];
                    long s = (v == parent[c]) ? (n - subSize[c]) : subSize[v];
                    sum3 += sum2 * s;
                    sum2 += sum1 * s;
                    sum1 += s;
                }

                ans += sum2 + sum3;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
