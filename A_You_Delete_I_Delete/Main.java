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
            String s = br.readLine().trim();

            String bestFinalString = null;

            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                
                    String afterAlice = s.substring(0, i) + s.substring(i + 1);

                    
                    String bobsBestString = null;
                    for (int j = 0; j < afterAlice.length(); j++) {
                        if (afterAlice.charAt(j) == '1') {
                            String candidate = afterAlice.substring(0, j) + afterAlice.substring(j + 1);
                            if (bobsBestString == null || candidate.compareTo(bobsBestString) < 0) {
                                bobsBestString = candidate;
                            }
                        }
                    }

                    
                    if (bestFinalString == null || bobsBestString.compareTo(bestFinalString) > 0) {
                        bestFinalString = bobsBestString;
                    }
                }
            }

            sb.append(bestFinalString).append("\n");
        }

        System.out.print(sb);
    }
}
