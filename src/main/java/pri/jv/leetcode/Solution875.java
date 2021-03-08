package pri.jv.leetcode;

/**
 * @ClassName Solution875
 * @Dscription
 * @Date 3/2/21
 * @Author JV
 **/
public class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = piles[0];
        int min = 1;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (piles.length == H) {
            return max;
        }

        int left = min;
        int right = max;
        while (left < right) {
            int speed = (left + right) / 2;
            int sum = 0;
            for (int pile : piles) {
                sum += (pile + speed - 1) / speed;
            }
            if (sum > H) {
                left = speed + 1;
            } else if (sum == H) {
                right = speed;
            } else {
                right = speed - 1;
            }
        }
        return left;
    }
}
