import java.io.*;

public class Main {

   
    static String reduce(String s, int n) {
        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (top > 0 && stack[top - 1] == c) {
                top--; 
            } else {
                stack[top++] = c;
            }
        }
        return new String(stack, 0, top);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String a = br.readLine().trim();
            String b = br.readLine().trim();

            int count0_a = 0;
            int count0_b = 0;

            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '0') count0_a++;
                if (b.charAt(i) == '0') count0_b++;
            }

        
            if (count0_a == count0_b && reduce(a, n).equals(reduce(b, n))) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}
