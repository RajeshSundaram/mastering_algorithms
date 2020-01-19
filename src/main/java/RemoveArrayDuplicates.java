import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveArrayDuplicates {

    public static void main(String[] args) {
        Integer[] input = { 1,2,3, -5, 6, 7, 3, 1,9};
        input = removeDuplicates(Integer.class, input);
        for(Integer i: input) {
            if(i != null) {
                System.out.print(i + " ");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T[] removeDuplicates(Class<T> type, T[] input)  {
        Arrays.sort(input);
        T[] result = (T[]) Array.newInstance(type, input.length);
        result[0] = input[0];
        for (int i=1, j=1;i < input.length; ++i) {
            if(input[i - 1] != input[i]) {
                result[j++] = input[i];
            }
        }
        return result;
    }
}
