


public class FindPrimeOrNot {

    public static void main(String[] args) {
        long n = 17;
        System.out.println(Math.sqrt(n));
        boolean isPrime = true;
        for (int i=2; i<= Math.sqrt(n); i++) {
            if(n%i ==0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            System.out.println("Its Prime Number");
        } else {
            System.out.println("Not Prime");
        }

    }
}
