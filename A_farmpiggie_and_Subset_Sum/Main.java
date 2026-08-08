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
            int[] p = new int[n + 1];

            int evenNum = 2;
            int oddNum = 1;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    
                    p[i] = evenNum;
                    evenNum += 2;
                } else {
                    
                    p[i] = oddNum;
                    oddNum += 2;
                }
            }

            for (int i = 1; i <= n; i++) {
                sb.append(p[i]).append(i == n ? "" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
