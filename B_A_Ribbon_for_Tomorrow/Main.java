import java.io.InputStream;
import java.io.IOException;

public class Main {
    static final int MOD = 998244353;
    static final int MAXN = 1000005;
    static long[] fact = new long[MAXN];
    static long[] invFact = new long[MAXN];

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

        public int readString(byte[] dest, int n) throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            for (int i = 0; i < n; i++) {
                dest[i] = (byte) c;
                c = read();
            }
            return n;
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

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i < MAXN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAXN - 1] = power(fact[MAXN - 1], MOD - 2);
        for (int i = MAXN - 2; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public static void main(String[] args) throws IOException {
        precompute();
        FastScanner sc = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        byte[] s = new byte[MAXN];

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.readString(s, n);

            int cnt0 = 0, cnt1 = 0;
            int b0 = 0, b1 = 0;

            for (int i = 0; i < n; i++) {
                if (s[i] == '0') {
                    cnt0++;
                    if (i == 0 || s[i - 1] != '0') {
                        b0++;
                    }
                } else {
                    cnt1++;
                    if (i == 0 || s[i - 1] != '1') {
                        b1++;
                    }
                }
            }

            long ways0 = (b0 == 0) ? 1 : nCr(cnt0 - 1, b0 - 1);
            long ways1 = (b1 == 0) ? 1 : nCr(cnt1 - 1, b1 - 1);

            long ans = (ways0 * ways1) % MOD;
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
