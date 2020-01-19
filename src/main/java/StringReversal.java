

public class StringReversal {

    public static void main(String[] args) {
        String input = "My Name is Rajesh";
        System.out.println(reversal(input));
        System.out.println(reversalIteration(input));
    }

    private static String reversal(String input) {
        int len = input.length();
        if(len == 1) {
            return input;
        }
        return input.charAt(len - 1) + reversal(input.substring(0, len - 1));
    }

    private static String reversalIteration(String input) {
        char[] result = new char[input.length()];
        for(int i=input.length()-1, j=0; i>=0; i--, j++) {
            result[j] = input.charAt(i);
        }
        return String.valueOf(result);
    }
}
