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
            int x = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            
            if (x == 1) {
                sb.append(0).append("\n");
                continue;
            }

          
            List<Integer> primes = new ArrayList<>();
            int temp = x;
            for (int i = 2; i * i <= temp; i++) {
                if (temp % i == 0) {
                    primes.add(i);
                    while (temp % i == 0) {
                        temp /= i;
                    }
                }
            }
            if (temp > 1) {
                primes.add(temp);
            }

          
            long maxCoins = 0;
            for (int p : primes) {
                long currentCoins = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] % p == 0) {
                        currentCoins += a[i];
                    }
                }
                
               
                if (currentCoins > maxCoins) {
                    maxCoins = currentCoins;
                }
            }

            sb.append(maxCoins).append("\n");
        }
        
        System.out.print(sb);
    }
}
