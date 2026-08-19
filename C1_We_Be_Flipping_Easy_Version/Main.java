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
            int[] a = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> ops = new ArrayList<>();
            boolean flipped = false; 
            
            for (int i = n - 1; i >= 0; i--) {
                int current_val = flipped ? -a[i] : a[i];
                
                
                if (current_val > 0) {
                    ops.add(i + 1); 
                    flipped = !flipped; 
                }
            }

            
            sb.append(ops.size()).append("\n");
            for (int i = 0; i < ops.size(); i++) {
                sb.append(ops.get(i)).append(i == ops.size() - 1 ? "" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
