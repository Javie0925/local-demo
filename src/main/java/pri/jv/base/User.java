package pri.jv.base;

/**
 * @ClassName User
 * @Dscription
 * @Date 3/2/21
 * @Author JV
 **/
public class User {

    private static String staticName = "jv";
    private String name = "javie";

    public String getStaticName() {
        return staticName;
    }

    public void setStaticName(String staticName) {
        User.staticName = staticName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hi(){
        System.out.println("hi");
    }

    public class InnerUser{
        public String innerName = "inner";
    }
}
