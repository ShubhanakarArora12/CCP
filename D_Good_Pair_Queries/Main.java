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

        public int read() throws IOException {
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
            int q = sc.nextInt();

            byte[] sBytes = new byte[n];
            int c = sc.read();
            while (c <= 32) c = sc.read();
            for (int i = 0; i < n; i++) {
                sBytes[i] = (byte) c;
                c = sc.read();
            }

            byte[] tBytes = new byte[n];
            while (c <= 32) c = sc.read();
            for (int i = 0; i < n; i++) {
                tBytes[i] = (byte) c;
                c = sc.read();
            }

            int[] pref00 = new int[n + 1];
            int[] pref01 = new int[n + 1];
            int[] pref10 = new int[n + 1];
            int[] pref11 = new int[n + 1];


            for (int i = 0; i < n; i++) {
                pref00[i + 1] = pref00[i];
                pref01[i + 1] = pref01[i];
                pref10[i + 1] = pref10[i];
                pref11[i + 1] = pref11[i];

                if (sBytes[i] == '0' && tBytes[i] == '0') pref00[i + 1]++;
                else if (sBytes[i] == '0' && tBytes[i] == '1') pref01[i + 1]++;
                else if (sBytes[i] == '1' && tBytes[i] == '0') pref10[i + 1]++;
                else if (sBytes[i] == '1' && tBytes[i] == '1') pref11[i + 1]++;
            }

           
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();

                int c00 = pref00[r] - pref00[l - 1];
                int c01 = pref01[r] - pref01[l - 1];
                int c10 = pref10[r] - pref10[l - 1];
                int c11 = pref11[r] - pref11[l - 1];

              
                if (c11 + c00 >= Math.abs(c10 - c01)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb);
    }
}
