import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int u = 1;
            int maxD = 0;
            
           
            for (int i = 2; i <= n; i++) {
                while (true) {
                    System.out.println("? 1 " + i + " " + (maxD + 1));
                    System.out.flush();
                    
                    int res = sc.nextInt();
                    if (res == -1) System.exit(0);
                    
                    if (res == 1) {
                        u = i;
                        maxD++;
                    } else {
                        break;
                    }
                }
            }
            
            int v = 1;
            int dia = maxD;
            
            
            for (int i = 2; i <= n; i++) {
                if (i == u) continue;
                
                while (true) {
                    System.out.println("? " + u + " " + i + " " + (dia + 1));
                    System.out.flush();
                    
                    int res = sc.nextInt();
                    if (res == -1) System.exit(0);
                    
                    if (res == 1) {
                        v = i;
                        dia++;
                    } else {
                        break;
                    }
                }
            }
            
           
            System.out.println("! " + u + " " + v + " " + dia);
            System.out.flush();
        }
    }
}
