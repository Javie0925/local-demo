package pri.jv.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * @ClassName ParallelStreamTest
 * @Dscription
 * @Date 2021/1/16
 * @Author JV
 **/
public class ParallelStreamTest {

    public static void main(String[] args) {
        measureSumPerf(num->{
            long sum = LongStream.rangeClosed(0L, num)
                    .reduce(0L, Long::sum);
            return sum;
        },1000000000);
        measureSumPerf(num->{
            long sum = LongStream.rangeClosed(0L, num)
                    .parallel()
                    .reduce(0L, Long::sum);
            return sum;
        },1000000000);
    }

    public static void measureSumPerf(Function<Long, Long> f, long num) {
        List<Long> duratimeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = f.apply(num);
            long duration = (System.nanoTime() - start) / 1_000_000;
            duratimeList.add(duration);
        }
        long reduce = duratimeList.stream()
                .mapToLong(i -> i.longValue())
                .reduce(0, Long::sum);
        System.out.println("duration is:"+reduce);
    }
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        Long reduce = Stream.iterate(0L, i -> i + 1)
//                .limit(1000000000)
//                .parallel()
//                .reduce(0L, Long::sum);
//        long end = System.currentTimeMillis();
//        System.out.println(reduce);
//        System.out.println("time custing:"+(end-start));
//    }
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        Long reduce = Stream.iterate(0L, i -> i + 1)
//                .limit(1000000000)
//                .reduce(0L, Long::sum);
//        long end = System.currentTimeMillis();
//        System.out.println(reduce);
//        System.out.println("time custing:"+(end-start));
//        //11498ms
//    }
}
