import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1, 4, 7, 11, 15],
 *   [2, 5, 8, 12, 19],
 *   [3, 6, 9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * Created by Bleibtreu on 2020/7/23 10:56
 */
public class FindNumberIn2DArray {

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了17.30%的用户
     * 内存消耗：44.5 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param target
     * @param matrix
     * @return
     */
    public boolean findNumberIn2DArray1(int target, int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length < 0 || matrix[0].length > 1000)
            return false;
        if (matrix.length < 0 || matrix.length > 1000)
            return false;
        AtomicBoolean result = new AtomicBoolean(false);
        Arrays.stream(matrix).parallel().forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                if (y == target) {
                    result.set(true);
                    return;
                }
            });
        });
        return result.get();
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：45.4 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param target
     * @param matrix
     * @return
     */
    public boolean findNumberIn2DArray2(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length < 0 || matrix[0].length > 1000)
            return false;
        if (matrix.length < 0 || matrix.length > 1000)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumber = new FindNumberIn2DArray();
        int [][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
//        System.out.println(findNumber.findNumberIn2DArray1(20, matrix));
        System.out.println(findNumber.findNumberIn2DArray2(20, matrix));
    }

}
