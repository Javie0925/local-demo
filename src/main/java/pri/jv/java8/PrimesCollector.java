package pri.jv.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @ClassName PrimesCollector
 * @Dscription
 * @Date 2021/1/11
 * @Author JV
 **/
public class PrimesCollector implements Collector<Integer, Map<String, List<Integer>>, Map<String, List<Integer>>> {

    @Override
    public Supplier<Map<String, List<Integer>>> supplier() {

        return () -> {
            HashMap<String, List<Integer>> map = new HashMap<>();
            map.put("prime", new ArrayList<>());
            map.put("notPrime", new ArrayList<>());
            return map;
        };
    }

    @Override
    public BiConsumer<Map<String, List<Integer>>, Integer> accumulator() {
        return (map,num)->{
//            IntStream.rangeClosed(2,num/2).anyMatch(i->num%i==0)?map.put("notPrime",new Integer(num));
        };
    }

    @Override
    public BinaryOperator<Map<String, List<Integer>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<String, List<Integer>>, Map<String, List<Integer>>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
