import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列）
 * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * Created by Bleibtreu on 2020/2/25 10:16
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int tempRow = 0;
        int tempColumn = 0;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        for (int i = 1; i < matrix[0].length; i++) {
            for (tempColumn = i; tempColumn > -1; tempColumn--, tempRow++) {
                result.add(matrix[tempRow][tempColumn]);
                if (tempRow == tempColumn) break;
            }
            tempRow = 0;
        }
        for (int i = tempRow; i < matrix.length; i++) {
            for (int j = tempColumn; j > -1; i++) {
                result.add(matrix[i][j]);
                if (i == matrix.length && j == matrix[0].length) break;
            }
        }
        Integer[] resultIntegerArray = new Integer[result.size()];
        resultIntegerArray = result.toArray(resultIntegerArray);
        int[] resultArray = Arrays.stream(resultIntegerArray).mapToInt(Integer::valueOf).toArray();
        return resultArray;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往右移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往下移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往上移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public int[] findDiagonalOrder3(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int arrLength = matrix.length * matrix[0].length;
        int[] resultArr = new int[arrLength]; //结果数组
        int i = 0; //行索引
        int j = 0; //列索引
        int index = 0;
        boolean direction = false; //true代表斜上，false代表斜下
        while (index <= arrLength - 1) {
            resultArr[index++] = matrix[i][j];//将当前遍历数存入结果数组
            if (direction) {//斜上
                if (i == matrix.length - 1) {
                    j++;
                    direction = false;
                } else if (j == 0) {
                    i++;
                    direction = false;
                } else {//正常情况
                    j--;
                    i++;
                }
            } else {//斜下
                if (j == matrix[0].length - 1) {
                    i++;
                    direction = true;
                } else if (i == 0) {
                    j++;
                    direction = true;
                } else {//正常情况
                    j++;
                    i--;
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = findDiagonalOrder.findDiagonalOrder3(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
