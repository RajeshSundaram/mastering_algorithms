import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GCDOfTwoNumbers {

    public static void main(String[] args) {
        int x = 54, y = 24;
        printGCD(x, y);
    }

    private static void printGCD(int x, int y) {
        Set<Integer> xdivisors =
                IntStream.range(1, x+1).filter(i -> x%i == 0).mapToObj(i -> i).collect(Collectors.toSet());
        int maxDivisor =
                IntStream.range(1, y+1).filter(i -> xdivisors.contains(i) && y%i == 0)
                        .reduce(1, (a, b) -> Math.max(a,b));
        System.out.println(maxDivisor);
    }
}
