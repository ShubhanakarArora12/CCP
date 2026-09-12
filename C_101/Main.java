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
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int first1 = -1, last1 = -1;
            int firstMinus1 = -1, lastMinus1 = -1;
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == 1) {
                    if (first1 == -1) first1 = i;
                    last1 = i;
                } else if (a[i] == -1) {
                    if (firstMinus1 == -1) firstMinus1 = i;
                    lastMinus1 = i;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) {
                    if (first1 == -1) {
                        // If there are no fixed 1s, use the extreme -1s as the bookends
                        if (i == firstMinus1 || i == lastMinus1) {
                            a[i] = 1;
                        } else {
                            a[i] = 0;
                        }
                    } else {
                        // If fixed 1s exist, only place 1s completely outside their bounds
                        if (i == firstMinus1 && i < first1) {
                            a[i] = 1;
                        } else if (i == lastMinus1 && i > last1) {
                            a[i] = 1;
                        } else {
                            a[i] = 0;
                        }
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(i == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
