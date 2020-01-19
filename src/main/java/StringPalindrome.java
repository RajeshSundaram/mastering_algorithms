public class StringPalindrome {
    public static void main(String[] args) {
        String input = "MadaM";
        if(isPalindrome(input) && isPalindromeR(input)) {
            System.out.println("Yes");
        } else  {
            System.out.println("No");
        }
    }

    private static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int len = input.length() - 1;
        boolean isPalidrome = true;
        for(int i=0; i< len/2; i++) {
            if(input.charAt(i) != input.charAt(len - i)) {
                isPalidrome = false;
                break;
            }
        }
        return isPalidrome;
    }

    private static boolean isPalindromeR(String input) {
        if(input.length() == 1) {
            return true;
        } else if(input.charAt(0) == input.charAt(input.length() -1 )) {
            return isPalindrome(input.substring(1, input.length() - 1 ));
        }
        return false;
    }
}
