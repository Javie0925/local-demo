package pri.jv.exception;

/**
 * @ClassName ExceptionDemo
 * @Dscription
 * @Date 3/6/21
 * @Author JV
 **/
public class ExceptionDemo {

    public String hi() throws RuntimeException{
        try{
            return "try";
        }catch (Exception e){
            return "catch";
        }finally {
            return "finally";
        }
    }

    public void loadClassDemo() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("pri.jv.handler.Hello");
        Class<?> bClass = Class.forName("pri.jv.handler.Hello");

    }

    public static void main(String[] args) throws ClassNotFoundException {
        new ExceptionDemo().loadClassDemo();
        try {

        }finally {

        }
    }
}
