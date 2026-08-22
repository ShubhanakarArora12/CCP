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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
           
            int[] a = new int[k + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            
            int[] b = new int[n + 1];
            
            int[] count = new int[k + 2];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                count[b[i]]++;
            }
            
            List<Integer> ops = new ArrayList<>();
            boolean possible = true;
            
           
            while (count[k + 1] < n) {
                boolean found = false;
                
                
                for (int L = k; L >= 1; L--) {
                    if (count[L] > 0) {
                       
                        if (L == k || count[L + 1] < a[L + 1]) {
                           
                            for (int i = 1; i <= n; i++) {
                                if (b[i] == L) {
                                    b[i]++;          
                                    count[L]--;      
                                    count[L + 1]++;  
                                    ops.add(i);      
                                    found = true;
                                    break;
                                }
                            }
                            break; 
                        }
                    }
                }
                
                
                if (!found) {
                    possible = false;
                    break;
                }
            }
            

            if (!possible) {
                sb.append("-1\n");
            } else {
                sb.append(ops.size()).append("\n");
                for (int i = 0; i < ops.size(); i++) {
                    sb.append(ops.get(i)).append(i == ops.size() - 1 ? "" : " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
