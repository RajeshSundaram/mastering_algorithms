public class IntegerPallindrome {

    public static void main(String[] args) {
        int n = 151;
        if(isPalindrome(n)) {
            System.out.println("Yes");
        } else  {
            System.out.println("No");
        }
    }

    private static boolean isPalindrome(int n) {
        int input = n;
        int remainder,reverseNum = 0;
        while (n != 0) {
            remainder = n % 10;
            reverseNum = (reverseNum * 10) + remainder;
            n /= 10;
        }
        return reverseNum == input;
    }
}
