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

        int multTestQ = sc.nextInt();
        if (multTestQ == -1) return;

        while (multTestQ-- > 0) {
            int n = sc.nextInt();
            long base_score = 0;
            long capacity = 0;
            long ones = 0;
            int m_count = 0;

            for (int i = 0; i < n; i++) {
                long c = sc.nextLong();
                if (c == 1) {
                    ones++;
                } else if (c >= 2) {
                    m_count++;
                    base_score += c;
                    capacity += (c - 2) / 2;
                }
            }

            long ans = 0;
            if (m_count == 0) {
                ans = 0;
            } else if (m_count == 1) {
                capacity = base_score / 2;
                ans = base_score + Math.min(ones, capacity);
                if (ans < 3) {
                    ans = 0;
                }
            } else {
                ans = base_score + Math.min(ones, capacity);
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
