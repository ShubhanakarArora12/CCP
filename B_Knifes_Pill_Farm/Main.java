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
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

          
            if (m == 1) {
                long maxScore = Long.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    maxScore = Math.max(maxScore, a[i]);
                }
                sb.append(maxScore).append("\n");
                continue;
            }

            
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(m, Collections.reverseOrder());
            long heapSum = 0;
            long maxScore = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
               
                if (maxHeap.size() == m - 1) {
                    long currentScore = (long) m * a[i] - heapSum;
                    if (currentScore > maxScore) {
                        maxScore = currentScore;
                    }
                }

                
                if (maxHeap.size() < m - 1) {
                    maxHeap.offer(a[i]);
                    heapSum += a[i];
                } else if (a[i] < maxHeap.peek()) {
                    heapSum -= maxHeap.poll();
                    maxHeap.offer(a[i]);
                    heapSum += a[i];
                }
            }

            sb.append(maxScore).append("\n");
        }

        System.out.print(sb);
    }
}
