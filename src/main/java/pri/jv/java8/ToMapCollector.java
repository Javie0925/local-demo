package pri.jv.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @ClassName ToMapCollector
 * @Dscription
 * @Date 2021/1/11
 * @Author JV
 **/
public class ToMapCollector<T> implements Collector<T, Map<String, T>, Map<String, T>> {

    @Override
    public Supplier<Map<String, T>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, T>, T> accumulator() {
        return (a, b) -> a.put(b.toString(), b);
    }

    @Override
    public BinaryOperator<Map<String, T>> combiner() {
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<String, T>, Map<String, T>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of( Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
