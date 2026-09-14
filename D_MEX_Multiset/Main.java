import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] a = new int[n];
            int count0 = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == 0) {
                    count0++;
                }
            }

           
            if (count0 == 1) {
                sb.append("NO\n");
                continue;
            }

            sb.append("YES\n");

            
            int[] sorted_a = a.clone();
            Arrays.sort(sorted_a);

            int X = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (sorted_a[i] == X) {
                    count++;
                } else if (sorted_a[i] > X) {
                    if (count < 2) {
                        break;
                    }
                    X++;
                    if (sorted_a[i] == X) {
                        count = 1;
                    } else {
                        count = 0;
                        break;
                    }
                }
            }
            if (count >= 2) {
                X++;
            }

           
            boolean[] inA = new boolean[X];
            boolean[] inB = new boolean[X];
            char[] ans = new char[n];

            for (int i = 0; i < n; i++) {
                int val = a[i];
                if (val < X) {
                    if (!inA[val]) {
                        inA[val] = true;
                        ans[i] = 'A';
                    } else if (!inB[val]) {
                        inB[val] = true;
                        ans[i] = 'B';
                    } else {
                        ans[i] = 'A'; 
                    }
                } else {
                    ans[i] = 'C'; 
                }
            }
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
}
