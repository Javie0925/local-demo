package pri.jv.channeldemo;

/**
 * @ClassName DemoBean
 * @Dscription
 * @Date 2020/8/10
 * @Author JV
 **/
public class DemoBean {

    private String name;
    private String age;
    private String address;
    private String mail;
    private String tel;
    private String gender;

    @Override
    public String toString() {
        return "DemoBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
