import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        if (line == null) return;
        int qrTNum = Integer.parseInt(line.trim());
        
        while (qrTNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            long X = (long) k ^ n;
            long P = 1;
            while (P <= n - 1) {
                P *= 2;
            }
            
            if (X >= P) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
                List<Integer> S = new ArrayList<>();
                for (int i = 0; i <= 30; i++) {
                    if ((X & (1L << i)) != 0) {
                        S.add(1 << i);
                    }
                }
                
                int c0 = n - 1 - S.size();
                int[] v = new int[n];
                int idx = 0;
                for (int i = 0; i < c0; i++) {
                    v[idx++] = 0;
                }
                for (int x : S) {
                    v[idx++] = x;
                }
                v[n - 1] = n;
                
                int[] p = new int[n];
                boolean[] used = new boolean[n];
                int maxAvail = n - 1;
                
                for (int i = n - 1; i >= 0; i--) {
                    int vi = v[i];
                    int prev_v = (i == 0) ? 0 : v[i - 1];
                    if (vi > prev_v) {
                        p[i] = prev_v;
                        used[prev_v] = true;
                    } else {
                        while (maxAvail >= 0 && used[maxAvail]) {
                            maxAvail--;
                        }
                        p[i] = maxAvail;
                        used[maxAvail] = true;
                    }
                }
                
                for (int i = 0; i < n; i++) {
                    sb.append(p[i]).append(i == n - 1 ? "" : " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
