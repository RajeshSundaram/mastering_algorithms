import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FibbonacciSeries {

    public static void main(String[] args) {
        long n = 5;
//        test(n, FibbonacciSeries.fibbWOCache);
//        test(n, FibbonacciSeries.fibbWithCache);

//         fibbonacci using iteration
        long a = 0, b = 1, sum = 0;
        for(int i=1;i <= n ; i++) {
            System.out.print(a + " ");
            sum = a + b;
            a = b;
            b = sum;
        }

    }

    public static void test(long n, LongFunction<Long> fibb) {
        long start = System.currentTimeMillis();
        String out = LongStream.range(0, n).mapToObj(i -> fibb.apply(i).toString())
                .collect(Collectors.joining(", "));
        long end = System.currentTimeMillis();
        System.out.println(out);
        System.out.println( TimeUnit.MILLISECONDS.toSeconds(end - start) +"'s" );
    }

    private static LongFunction<Long> fibbWOCache = (n) -> {
        if (n == 0) {
            return 0L;
        } else if(n == 1) {
            return 1L;
        }
        return FibbonacciSeries.fibbWOCache.apply(n-1) + FibbonacciSeries.fibbWOCache.apply(n-2);
    };

    private static LongFunction<Long> fibbWithCache = (n) -> {
        if (n == 0) {
            return 0L;
        } else if(n == 1) {
            return 1L;
        } else if(FibbonacciSeries.cache.containsKey(n)) {
            return FibbonacciSeries.cache.get(n);
        }
        long out = FibbonacciSeries.fibbWithCache.apply(n-1) + FibbonacciSeries.fibbWithCache.apply(n-2);
        FibbonacciSeries.cache.put(n, out);
        return out;
    };

    private static Map<Long, Long> cache = new HashMap<>();
}
