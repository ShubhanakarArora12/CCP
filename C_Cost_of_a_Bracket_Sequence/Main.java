import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        public int readString(byte[] dest) throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int len = 0;
            while (c > 32) {
                dest[len++] = (byte) c;
                c = read();
            }
            return len;
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
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();
        if (t == -1) return;

        byte[] sBytes = new byte[5005];

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.readString(sBytes);

           
            if (k >= n) {
                for (int i = 0; i < n; i++) out.append('1');
                out.append('\n');
                continue;
            }

            List<Integer> lefts = new ArrayList<>(n);
            List<Integer> rights = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                if (sBytes[i] == '(') {
                    lefts.add(i);
                } else {
                    rights.add(i);
                }
            }

           
            int minX = Math.max(0, k - rights.size());
            int maxX = Math.min(k, lefts.size());

            int minCost = Integer.MAX_VALUE;
            boolean[] bestDel = new boolean[n];

            for (int x = minX; x <= maxX; x++) {
                int y = k - x;

                boolean[] del = new boolean[n];
                
                
                for (int i = 0; i < x; i++) {
                    del[lefts.get(i)] = true;
                }
               
                for (int i = 0; i < y; i++) {
                    del[rights.get(rights.size() - 1 - i)] = true;
                }

                int openCnt = 0;
                int cost = 0;

               
                for (int i = 0; i < n; i++) {
                    if (!del[i]) {
                        if (sBytes[i] == '(') {
                            openCnt++;
                        } else {
                            if (openCnt > 0) {
                                openCnt--;
                                cost += 2;
                            }
                        }
                    }
                }

                if (cost < minCost) {
                    minCost = cost;
                    System.arraycopy(del, 0, bestDel, 0, n);
                }
                
                
                if (minCost == 0) {
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                out.append(bestDel[i] ? '1' : '0');
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}
