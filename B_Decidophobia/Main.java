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
            int d = sc.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            
            long[] pref = new long[2 * n + 1];
            for (int i = 0; i < 2 * n; i++) {
                pref[i + 1] = pref[i] + a[i >= n ? i - n : i];
            }

            long ans = 0;
            long twoD = 2L * d;
            for (int i = 0; i < n; i++) {
                long rightSum = pref[i + d + 1] - pref[i + 1];
                long leftSum = pref[i + n] - pref[i + n - d];
                long contribution = twoD * a[i] - (leftSum + rightSum);
                if (contribution > 0) {
                    ans += contribution;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
