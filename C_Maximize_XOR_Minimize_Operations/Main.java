import java.io.*;
import java.util.*;

public class Main {

    static boolean canAchieve(long minX, long maxX, long limitX) {
        return minX <= limitX;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        int qrTNum = Integer.parseInt(line.trim());

        while (qrTNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long S = x + y;
            long curX = 0;
            long curY = 0;
            long ansXor = 0;

            for (int b = 29; b >= 0; b--) {
                long bit = 1L << b;
                long maxRemSingle = bit - 1;
                long remS = S - curX - curY;

                boolean canXor1 = false;
                boolean canX1Y0 = false;
                boolean canX0Y1 = false;

                if (remS >= bit && remS - bit <= 2 * maxRemSingle) {
                    long remAfter = remS - bit;
                    long minLowX = Math.max(0L, remAfter - maxRemSingle);

                    if (curX + bit + minLowX <= x) {
                        canX1Y0 = true;
                    }
                    if (curX + minLowX <= x) {
                        canX0Y1 = true;
                    }
                    canXor1 = canX1Y0 || canX0Y1;
                }

                if (canXor1) {
                    ansXor |= bit;
                    if (canX1Y0) {
                        curX += bit;
                    } else {
                        curY += bit;
                    }
                } else {
                    if (remS >= 2 * bit) {
                        curX += bit;
                        curY += bit;
                    }
                }
            }

            long ops = x - curX;
            sb.append(ansXor).append(" ").append(ops).append("\n");
        }

        System.out.print(sb);
    }
}
