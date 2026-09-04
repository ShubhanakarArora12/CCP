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

            long champion = 0;
            
            for (int i = 0; i < n; i++) {
                long currentPile = Long.parseLong(st.nextToken());
                

                if (champion > currentPile) {
                    champion += currentPile;
                } else {
                    champion = currentPile;
                }
            }
            
            sb.append(champion).append("\n");
        }

        System.out.print(sb);
    }
}
