package pri.jv.demo1;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.function.Function;

/**
 * @Dscription:
 * @Date 2020/7/13
 * @Author JV
 **/
public class Demo {

    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList();
        Queue<String> queue = new ArrayDeque<>();



    }

    public static String add(String param1,Function<String,String> fun){
        return fun.apply(param1);
    }
}
