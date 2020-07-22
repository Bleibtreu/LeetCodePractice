import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <P>
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * </p>
 * Created by Bleibtreu on 2020/5/18 11:51
 */
public class SpiralOrder {

    /**
     * 题目理解错误，实现了旋转外围参数
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 1;
        for (; i < matrix[0].length; i++) {
            result.add(matrix[0][i]);
        }
        for (i = i-1; j < matrix.length; j++) {
            result.add(matrix[j][i]);
        }
        for (i = j - 1, j = j - 1; j > 0; j--) {
            result.add(matrix[i][j]);
        }
        for (j = matrix.length -1; j >= 0; j--) {
            result.add(matrix[j][0]);
        }
        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        return result;
    }


    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int [][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            };
        List list = spiralOrder.spiralOrder1(matrix);
        list.forEach((x)->
            System.out.println(x)
        );
    }

}
