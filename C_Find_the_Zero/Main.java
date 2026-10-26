import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return -1;
            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    static int ask(int i, int j) throws IOException {
        System.out.println("? " + i + " " + j);
        System.out.flush();
        int res = nextInt();
       
        if (res == -1) {
            System.exit(0);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        if (t == -1) return;

        while (t-- > 0) {
            int n = nextInt();

            boolean found = false;
            
          
            for (int i = 1; i <= n - 1; i++) {
                int u = 2 * i - 1;
                int v = 2 * i;
                int res = ask(u, v);
                
            
                if (res == 1) {
                    System.out.println("! " + u);
                    System.out.flush();
                    found = true;
                    break;
                }
            }

            if (found) continue;

            
            int x = 2 * n - 1;
            int y = 2 * n;

            
            int res1 = ask(x, 1);
            if (res1 == 1) {
                System.out.println("! " + x);
                System.out.flush();
                continue;
            }

            int res2 = ask(x, 2);
            if (res2 == 1) {
                System.out.println("! " + x);
                System.out.flush();
                continue;
            }

            
            System.out.println("! " + y);
            System.out.flush();
        }
    }
}
