/**
 * Created by Bleibtreu on 2019/12/30 11:48
 */
public class DifferenceEven {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        int[] nums = {12,345,2,6,7896};
        System.out.println(DifferenceEven.class.newInstance().findNumbers(nums));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
