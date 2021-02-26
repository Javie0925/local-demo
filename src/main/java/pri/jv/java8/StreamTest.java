package pri.jv.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName StreamTest
 * @Dscription
 * @Date 2021/1/11
 * @Author JV
 **/
public class StreamTest {

    public static void main(String[] args) {
        Map<String, String> collect = Arrays.asList("1", "2", "3").stream().collect(Collectors.toMap(str->"k"+str,str->"v"+str));
        System.out.println(collect);

    }

    public static void main1(String[] args) {
        System.out.println(isPrime(1111));
    }

    public static boolean isPrime(int num) {
        return !IntStream.rangeClosed(2, num/2).anyMatch(i -> num % i == 0);
    }
}
