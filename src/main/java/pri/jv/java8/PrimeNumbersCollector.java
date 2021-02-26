//package pri.jv.java8;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//
//import java.util.*;
//import java.util.function.BiConsumer;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collector;
//
///**
// * @ClassName PrimeNumbersCollector
// * @Dscription
// * @Date 2021/1/15
// * @Author JV
// **/
//public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean,List<Integer>>, Map<Boolean,List<Integer>>> {
//    @Override
//    public Supplier<Map<Boolean, List<Integer>>> supplier() {
//        return ()->{
//            HashMap<Boolean, List<Integer>> map = new HashMap<>();
//            map.put(true,new ArrayList<Integer>());
//            map.put(false,new ArrayList<Integer>());
//            return map;
//        };
//    }
//
//    @Override
//    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
//        return (map,tar)->{
//            if (tar)
//        };
//    }
//
//    @Override
//    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
//        return null;
//    }
//
//    @Override
//    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
//        return null;
//    }
//
//    @Override
//    public Set<Characteristics> characteristics() {
//        return null;
//    }
//
//    public boolean isPrime(List<Integer> primes,int candidator){
//        int root =
//    }
//}
