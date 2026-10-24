import java.io.InputStream;
import java.io.IOException;
import java.util.PriorityQueue;

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
        StringBuilder out = new StringBuilder();
        
        int t = sc.nextInt();
        if (t == -1) return;
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }
            
            
            int[] a = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                a[i] = sc.nextInt();
            }
            
            int ans = m;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long currentSum = 0;
            
            
            for (int i = n - 1; i >= 0; i--) {
               
                for (int j = 0; j < m; j++) {
                    int x = a[i * m + j];
                    pq.add(x);
                    currentSum += x;
                    
                    
                    if (pq.size() > ans - 1) {
                        currentSum -= pq.poll();
                    }
                }
                
              
                while (!pq.isEmpty() && currentSum >= v[i]) {
                   
                    ans = pq.size();
                    
                   
                    currentSum -= pq.poll();
                }
            }
            
            out.append(ans).append("\n");
        }
        
        System.out.print(out);
    }
}
