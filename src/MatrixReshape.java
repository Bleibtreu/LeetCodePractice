import java.util.Arrays;

/**
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出: [[1,2,3,4]]
 * 解释: 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 * 示例 2:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释: 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 *
 * 注意：
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 *
 * Created by Bleibtreu on 2020/8/7 16:00
 */
public class MatrixReshape {

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length)
            return nums;
        int[][] ans = new int[r][c];
        int row = 0, col = 0;
        for (int[] i : nums) {
            for (int j : i) {
                ans[row][(col++) % c] = j;
                if (col % c == 0)
                    row++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MatrixReshape matrixReshape = new MatrixReshape();
        int [][] nums = {
                {1,2},
                {3,4}
        };
        Arrays.stream(matrixReshape.matrixReshape1(nums, 2, 2)).forEach(x-> Arrays.stream(x).forEach(y-> System.out.println(y)));
    }
}
