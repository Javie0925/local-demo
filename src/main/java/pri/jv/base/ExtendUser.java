package pri.jv.base;

/**
 * @ClassName ExtendUser
 * @Dscription
 * @Date 3/2/21
 * @Author JV
 **/
public class ExtendUser extends User {

    public void syaHi(){
        super.hi();
    }

    @Override
    public void hi(){
        final int age = 22;
        super.hi();
    }
}
