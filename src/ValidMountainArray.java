import java.util.Arrays;

/**
 * 给定一个整数数组A，如果它是有效的山脉数组就返回true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在0 < i < A.length - 1条件下，存在i使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 示例 1：     | 示例 2：      | 示例 2：
 * 输入：[2,1]  | 输入：[3,5,5] | 输入：[0,3,2,1]
 * 输出：false  | 输出：false   | 输出：true
 * <p>
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author bleibtreu
 * @date 2020/11/3 15:44
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] params = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Single -->" + validMountainArray.validMountainArraySingle(params));
        System.out.println("Double -->" + validMountainArray.validMountainArrayDouble(params));
        System.out.println("1ms -->" + validMountainArray.validMountainArray1ms(params));
    }

    public boolean validMountainArraySingle(int[] A) {
        if (A.length < 3) return false;
        int index = 1;
        while (index < A.length && A[index] >= A[index - 1]) {
            if (A[index] == A[index - 1]) {
                return false;
            }
            index++;
        }
        if (index == A.length || index == 1) return false;

        while (index < A.length && A[index] <= A[index - 1]) {
            if (A[index] == A[index - 1]) {
                return false;
            }
            index++;
        }
        return index == A.length;
    }

    /**
     * 双指针，从两头开始遍历
     * @param A
     * @return
     */
    public boolean validMountainArrayDouble(int[] A) {
        if (A.length < 3) return false;
        int left = 0;
        int right = A.length - 1;
        while (left < A.length - 1 && A[left] < A[left + 1]) {
            left++;
        }
        while (right > 0 && A[right] < A[right - 1]) {
            right--;
        }
        return (left == right) && left != 0 && left != A.length - 1;
    }

    /**
     * 耗时1ms
     * @param A
     * @return
     */
    public boolean validMountainArray1ms(int[] A) {
        if (A.length < 3) return false;
        int left = 0, right = A.length - 1;
        while (left < A.length - 2 && A[left] < A[left + 1]) left++;
        while (right > 1 && A[right] < A[right - 1]) right--;
        return left == right;
    }
}
