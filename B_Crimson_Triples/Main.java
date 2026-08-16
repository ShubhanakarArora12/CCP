import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long totalTriples = 0;

            
            for (long b = 1; b <= n; b++) {
                long count = n / b;
                totalTriples += count * count;
            }

            sb.append(totalTriples).append("\n");
        }

        System.out.print(sb);
    }
}
