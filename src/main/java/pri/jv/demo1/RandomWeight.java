package pri.jv.demo1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @ClassName RandomWeight
 * @Dscription
 * @Date 3/17/21
 * @Author JV
 **/
public class RandomWeight {

    private Random random = new Random();

    // 20,30,50
    public int getByWeight(int[] weight){
        int base = 0;
        for (int i=0;i<weight.length;i++){
            base+=weight[i];
        }
        //Arrays.sort(weight);
        int r = random.nextInt(base);
        for (int i=0;i<weight.length;i++){
            if (r<weight[i]){
                return i;
            }
            r -= weight[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        RandomWeight randomWeight = new RandomWeight();
        int c1=0,c2=0,c3=0,c4=0;
        int[] weight = {3,1,2};
        for (int i=0;i<10000000;i++){
            switch (randomWeight.getByWeight(weight)){
                case 0:
                    c1++;
                    break;
                case 1:
                    c2++;
                    break;
                case 2:
                    c3++;
                    break;
                default:
                    c4++;
                    break;
            }
        }
        BigDecimal b1 = BigDecimal.valueOf(c1);
        BigDecimal b2 = BigDecimal.valueOf(c2);
        BigDecimal b3 = BigDecimal.valueOf(c3);
        BigDecimal b4 = BigDecimal.valueOf(c4);
        System.out.printf("c1:c2:c3:c4=%s:%s:%s:%s",1,b2.divide(b1,5,RoundingMode.CEILING),b3.divide(b1,5,RoundingMode.CEILING),b4.divide(b1,2,RoundingMode.CEILING));
    }
}
