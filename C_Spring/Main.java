import java.io.*;
import java.util.*;

public class Main {
    
    
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            
            long nab = lcm(a, b);
            long nac = lcm(a, c);
            long nbc = lcm(b, c);
            long nabc = lcm(nab, c);

            
            long alice = 6 * (m / a) - 3 * (m / nab) - 3 * (m / nac) + 2 * (m / nabc);
            long bob   = 6 * (m / b) - 3 * (m / nab) - 3 * (m / nbc) + 2 * (m / nabc);
            long carol = 6 * (m / c) - 3 * (m / nac) - 3 * (m / nbc) + 2 * (m / nabc);

            sb.append(alice).append(" ").append(bob).append(" ").append(carol).append("\n");
        }

        System.out.print(sb);
    }
}
