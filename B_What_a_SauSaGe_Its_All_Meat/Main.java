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
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int multTestQ = sc.nextInt();
        if (multTestQ == -1) return;

        while (multTestQ-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] a = new int[n];
            int e = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (Integer.bitCount(a[i]) % 2 == 0) {
                    e++;
                }
            }

            sb.append(e).append(q == 0 ? "" : " ");

            for (int i = 0; i < q; i++) {
                int p = sc.nextInt() - 1;
                int x = sc.nextInt();

                if (Integer.bitCount(a[p]) % 2 == 0) {
                    e--;
                }

                a[p] = x;

                if (Integer.bitCount(a[p]) % 2 == 0) {
                    e++;
                }

                sb.append(e).append(i == q - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
