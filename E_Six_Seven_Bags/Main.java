import java.io.*;
import java.util.*;

public class Main {
    
    
    static long safe_pow(long base, long exp) {
        if (exp == 0) return 1;
        if (base == 0) return 0;
        long res = 1;
        for (int i = 0; i < exp; ++i) {
            if (res > 200000000000000L / base) return 200000000000000L;
            res *= base;
        }
        return res;
    }

   
    static int[] build(long rem, long m, int q, boolean must_have_m) {
        int[] res = new int[q];
        for (int i = 0; i < q; ++i) {
            int rem_q = q - 1 - i;
            if (rem_q == 0) {
                if (must_have_m) {
                    res[i] = (int)m;
                } else {
                    res[i] = (int)rem;
                }
                continue;
            }
            if (!must_have_m) {
                long power = safe_pow(m + 1, rem_q);
                res[i] = (int)(rem / power);
                rem %= power;
            } else {
                long W1 = safe_pow(m + 1, rem_q) - safe_pow(m, rem_q);
                if (rem < m * W1) {
                    res[i] = (int)(rem / W1);
                    rem %= W1;
                    must_have_m = true; 
                } else {
                    res[i] = (int)m;
                    rem -= m * W1;
                    must_have_m = false; 
                }
            }
        }
        return res;
    }

    static class Bag implements Comparable<Bag> {
        int capacity;
        int index;
        public Bag(int c, int i) { 
            this.capacity = c; 
            this.index = i; 
        }
        public int compareTo(Bag other) {
            return Integer.compare(this.capacity, other.capacity);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Bag[] bags = new Bag[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                bags[i] = new Bag(Integer.parseInt(st.nextToken()), i + 1);
            }
            
            Arrays.sort(bags);

            
            int q = 1;
            while (true) {
                boolean possible = true;
                for (int k = 0; k < n; ++k) {
                    if (k >= safe_pow(bags[k].capacity + 1, q)) {
                        possible = false;
                        break;
                    }
                }
                if (possible) break;
                q++;
            }

            int[][] orig_seq = new int[n + 1][q];
            
           
            for (int k = 0; k < n; ++k) {
                long m = 0;
                while (safe_pow(m + 1, q) <= k) {
                    m++;
                }
                long rem = k - safe_pow(m, q);
                int[] seq = build(rem, m, q, true);
                
                int bag_idx = bags[k].index;
                for (int j = 0; j < q; ++j) {
                    orig_seq[bag_idx][j] = seq[j];
                }
            }

            long[] X = new long[q];
           
            for (int j = 0; j < q; ++j) {
                StringBuilder query = new StringBuilder("?");
                long S = 0;
                for (int i = 1; i <= n; ++i) {
                    query.append(" ").append(orig_seq[i][j]);
                    S += orig_seq[i][j];
                }
                System.out.println(query.toString());
                System.out.flush();

                String wStr = br.readLine();
                if (wStr == null) System.exit(0);
                long W = Long.parseLong(wStr.trim());
                if (W == -1) System.exit(0); // Constraint breakage guard

              
                X[j] = 7L * S - W;
            }

         
            int ans = -1;
            for (int i = 1; i <= n; ++i) {
                boolean match = true;
                for (int j = 0; j < q; ++j) {
                    if (orig_seq[i][j] != X[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    ans = i;
                    break;
                }
            }
            
            System.out.println("! " + ans);
            System.out.flush();
        }
    }
}
