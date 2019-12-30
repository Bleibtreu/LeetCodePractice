import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bleibtreu on 2019/12/30 13:17
 */
public class IsPossibleDivide {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        int[] nums = {1,2,3,3,4,4,5,6};
        System.out.println(IsPossibleDivide.class.newInstance().isPossibleDivide(nums,4));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        Integer temp;
        int t;
        for (int i : nums) {
           if(map.get(i) == null) map.put(i,1);
           else {
               temp = map.get(i);
               map.put(i,++temp);
           }
        }
        for (int i = 0; i < nums.length; i++) {
            temp = map.get(nums[i]);
            t = nums[i];
            if (temp == 0) continue;
            map.put(t,--temp);
            for (int j = 0; j < k - 1; j++) {
                temp = map.get(++t);
                if ((Integer)temp == null || temp == 0) return false;
                else map.put(t,--temp);
            }
        }
        return true;
    }

}
