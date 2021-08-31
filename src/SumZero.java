/**
 * 给你一个整数n，请你返回 任意一个由 n个 各不相同的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *
 * 提示：
 * 1 <= n <= 1000
 *
 * @author bleibtreu
 * @date 2021/8/31
 */
public class SumZero {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(SumZero.class.newInstance().sumZero(5));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了47.61%的用户
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int start = n / 2 * -1;
        for (int i = 0; i < arr.length; i++) {
            if (n % 2 == 0) {
                if (start == 0) {
                    start++;
                }
            }
            arr[i] = start++;
        }
        return arr;
    }
}
