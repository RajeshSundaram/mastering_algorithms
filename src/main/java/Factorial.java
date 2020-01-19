public class Factorial {

    public static void main(String[] args) {
        int n = -5;
        boolean isNegativeAndOdd = (n < 0) && (n%2 != 0);
        if(isNegativeAndOdd) {
            n = -(n);
        }
        int fact1 = factorial(n);
        int fact2 = factorialUsingIteration(n);
        if( isNegativeAndOdd) {
            fact1 = -fact1;
            fact2 = -fact2;
        }
        System.out.printf("%d , %d", fact1, fact2);
    }

    private static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    private static int factorialUsingIteration(int n) {
        int result = 1;
        for(int i = 2;i <= n; i++) {
            result *=i;
        }
        return result;
    }
}
