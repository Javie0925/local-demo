package pri.jv.base;

/**
 * @ClassName Main
 * @Dscription
 * @Date 3/2/21
 * @Author JV
 **/
public class Main implements Cloneable{

    public static void main(String[] args) throws CloneNotSupportedException {

        Object a = new Object();
        Object b = a;
        b = new Object();
        System.out.println(a==b);
    }
}
