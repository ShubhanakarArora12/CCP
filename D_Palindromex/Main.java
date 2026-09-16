import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;

    
    static void update(int node, int start, int end, int val, int pos) {
        if (start == end) {
            tree[node] = pos;
            return;
        }
        int mid = (start + end) / 2;
        if (val <= mid) {
            update(2 * node, start, mid, val, pos);
        } else {
            update(2 * node + 1, mid + 1, end, val, pos);
        }
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

   
    static int query(int node, int start, int end, int L) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (tree[2 * node] < L) {
            return query(2 * node, start, mid, L);
        } else {
            return query(2 * node + 1, mid + 1, end, L);
        }
    }

    static class Query implements Comparable<Query> {
        int L, R;

        public Query(int l, int r) {
            L = l;
            R = r;
        }

        @Override
        public int compareTo(Query other) {
            return Integer.compare(this.R, other.R);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = 2 * n;
            int[] a = new int[m];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            
            int[] T = new int[2 * m + 3];
            T[0] = -1;
            T[1] = -2;
            for (int i = 0; i < m; i++) {
                T[2 * i + 2] = a[i];
                T[2 * i + 3] = -2;
            }
            T[2 * m + 2] = -3;

            
            int[] P = new int[T.length];
            int C = 0, R = 0;
            for (int i = 1; i < T.length - 1; i++) {
                int i_mirror = 2 * C - i;
                if (R > i) {
                    P[i] = Math.min(R - i, P[i_mirror]);
                } else {
                    P[i] = 0;
                }
                while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                    P[i]++;
                }
                if (i + P[i] > R) {
                    C = i;
                    R = i + P[i];
                }
            }

            
            List<Query> queries = new ArrayList<>();
            for (int i = 1; i < T.length - 1; i++) {
                if (P[i] > 0) {
                    int L_T = i - P[i] + 1;
                    int R_T = i + P[i] - 1;
                    
                    int first_even = (L_T % 2 == 0) ? L_T : L_T + 1;
                    int last_even = (R_T % 2 == 0) ? R_T : R_T - 1;
                    
                    if (first_even <= last_even) {
                        int L_idx = (first_even - 2) / 2;
                        int R_idx = (last_even - 2) / 2;
                        queries.add(new Query(L_idx, R_idx));
                    }
                }
            }

            Query[] qs = new Query[queries.size()];
            queries.toArray(qs);
            Arrays.sort(qs);

            
            tree = new int[4 * (n + 1)];
            Arrays.fill(tree, -1);
            
            int qIdx = 0;
            int maxMex = 0;

            for (int i = 0; i < m; i++) {
               
                update(1, 0, n, a[i], i);
                
               
                while (qIdx < qs.length && qs[qIdx].R == i) {
                    int mex = query(1, 0, n, qs[qIdx].L);
                    if (mex > maxMex) {
                        maxMex = mex;
                    }
                    qIdx++;
                }
            }

            sb.append(maxMex).append("\n");
        }
        System.out.print(sb);
    }
}
