public class PatternGenerator {
    public static void main(String[] args) {
        printPattern();
        printPraymid();
    }

    private static void printPraymid() {
        int n = 20;
        for(int i=1;i <= n; i++) {
            for(int j=1; j <= 40 - i ; j++ ) {
                    System.out.print(" ");
            }
            for(int k=1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPattern() {
        for(int i=1; i<=10;++i) {
            int j=i;
            while(j > 0) {
                System.out.print("*  ");
                j--;
            }
            System.out.println();
        }
    }
}
