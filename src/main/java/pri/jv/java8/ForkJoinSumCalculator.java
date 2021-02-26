package pri.jv.java8;

import java.util.concurrent.RecursiveTask;

/**
 * @ClassName ForkJoinSumCalculator
 * @Dscription
 * @Date 2021/1/19
 * @Author JV
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] nums;

    private final int start;

    private final int end;

    public static final long THREAD = 10000;

    public ForkJoinSumCalculator(long[] nums) {
        this(nums, 0, nums.length);
    }

    public ForkJoinSumCalculator(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THREAD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator left = new ForkJoinSumCalculator(nums, start, start + length / 2);
        Long leftSum = left.compute();
        ForkJoinSumCalculator right = new ForkJoinSumCalculator(nums, start + length / 2, end);
        Long rightSum = left.compute();
        return leftSum + rightSum;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
