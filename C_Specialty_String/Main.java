import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
           
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
            
            
            if (top == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}
