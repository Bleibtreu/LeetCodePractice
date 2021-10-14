import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 提示：
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 * @author bleibtreu
 * @date 2021/10/14
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(CanPartitionKSubsets.class.newInstance().canPartitionKSubsets(nums, k));
    }

    private boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {return true;}
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {return false;}
        int count = sum / k;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());
        checkSubset(list,count);
        return true;
    }

    private static int[] checkSubset(List<Integer> nums, int count) {

        int border = nums.size() / 2;
        for (int i = nums.size()-1 ; i >= 0; i--) {
            if (nums.get(i) == count) {}

        }
        return true;
    }
}
