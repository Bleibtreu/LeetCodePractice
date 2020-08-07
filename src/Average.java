import java.util.Arrays;

/**
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值
 *
 * 示例 1：
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 *
 * 示例 2：
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 *
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] 是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案。
 *
 * Created by Bleibtreu on 2020/8/7 13:38
 */
public class Average {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了44.00%的用户
     * @param salary
     * @return
     */
    public double average1(int[] salary) {
        if (salary.length == 0)
            return 0;
        double maxValue = Double.MAX_VALUE;
        double minValue = Double.MIN_VALUE;
        double result= 0;
        for (int i : salary) {
            if (i > minValue)
                minValue = i;
            if (i < maxValue)
                maxValue = i;
            result += i;
        }
        result = (result - (maxValue + minValue))/(salary.length - 2);
        return result;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.2 MB, 在所有 Java 提交中击败了54.80%的用户
     * @param salary
     * @return
     */
    public double average2(int[] salary) {
        Arrays.sort(salary) ;
        double result = 0 ;
        int sum = 0 ;
        for(int i=1;i<salary.length-1;i++){
            sum+=salary[i] ;
        }
        result = (double)sum/(salary.length-2) ;
        return result ;
    }

    public static void main(String[] args) {
        Average average = new Average();
        int[] salary = {8000,9000,2000,3000,6000,1000};
        System.out.println(average.average2(salary));
    }

}
