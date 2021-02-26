package pri.jv.java8;

import java.util.stream.LongStream;

/**
 * @ClassName ForkJoinTest
 * @Dscription
 * @Date 2021/1/19
 * @Author JV
 **/
public class ForkJoinTest {

    public static void main(String[] args) {
        long[] longs = LongStream.rangeClosed(0, 100000000).toArray();
        long start = System.currentTimeMillis();
        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(longs);
        Long compute = forkJoinSumCalculator.compute();
        long end = System.currentTimeMillis();
        System.out.printf("duration:%s",end-start);
        //duration:55
     }

//    public static void main(String[] args) {
//        long[] longs = LongStream.rangeClosed(0, 100000000).toArray();
//        long sum = 0;
//        long start = System.currentTimeMillis();
//        for (long l : longs){
//            sum += l;
//        }
//        long end = System.currentTimeMillis();
//        System.out.printf("duration:%s",end-start);
////        duration:97
//    }

}
