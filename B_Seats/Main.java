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

            int first = -1;
            int last = -1;
            int initialCount = 0;
            int addedStudents = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    if (first == -1) {
                        first = i; 
                    }
                    if (last != -1) {
                        
                        int emptySeatsBetween = i - last - 1;
                        addedStudents += emptySeatsBetween / 3;
                    }
                    last = i; 
                    initialCount++;
                }
            }

            if (initialCount == 0) {
                
                sb.append((n + 2) / 3).append("\n");
            } else {
            
                addedStudents += (first + 1) / 3;
                
                
                addedStudents += (n - last) / 3;
                
              
                sb.append(initialCount + addedStudents).append("\n");
            }
        }

        System.out.print(sb);
    }
}
