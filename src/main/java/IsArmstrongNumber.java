public class IsArmstrongNumber {
    public static void main(String[] args) {
        int n = 153;
        if(isArmstrong(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isArmstrong(int n) {
        int input = n;
        int remainder, sum = 0;
        while(n != 0) {
            remainder = n % 10;
            n /= 10;
            sum += Math.pow(remainder, 3);
        }
        return input == sum;
    }
}
