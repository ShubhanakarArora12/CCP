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

            if (s.charAt(0) == '1') {
             
                int zeros = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        zeros++;
                    }
                }
                sb.append(zeros).append("\n");
            } else {
              
                int totalZeros = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        totalZeros++;
                    }
                }

                
                int minOps = totalZeros;
                int currentOnes = 0;
                int zerosAfter = totalZeros;

                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        currentOnes++;
                    } else {
                        zerosAfter--;
                    }
                  
                    minOps = Math.min(minOps, currentOnes + zerosAfter);
                }
                sb.append(minOps).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
