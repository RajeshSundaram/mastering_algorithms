

public class ReverseArray {
    public static void main(String[] args) {
        for(String x : reverseAnArray(String.class, new String[]{"a", "b", "c"})) {
            System.out.print(x + " ");
        }
    }

    private static <T> T[] reverseAnArray(Class<T> stringClass, T[] input) {
        int len = input.length - 1;
        for(int i=0;i < input.length/ 2; ++i) {
            T temp = input[i];
            input[i] = input[len - i];
            input[len - i] = temp;
        }
        return input;
    }
}
