import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）
 * <p>
 * 示例 1：
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * <p>
 * 示例 2：
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * Created by Bleibtreu on 2020/3/13 11:29
 */
public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String tempLow = String.valueOf(low);
        String lowFirstChar = String.valueOf(tempLow.toCharArray()[0]);
        int lowFirst = Integer.parseInt(lowFirstChar);
        int tempResult;
        StringBuffer stringBuffer = new StringBuffer(lowFirstChar);
        for (int i = 1; i < tempLow.length(); i++) {
            if ((lowFirst + i) > 9) {
                stringBuffer = new StringBuffer();
                for (int j = 0; j < tempLow.length() + 1; j++) {
                    stringBuffer.append(j + 1);
                }
                break;
            } else
                stringBuffer.append(lowFirst + i);
        }
        if (stringBuffer.toString().length() > 9)
            return result;
        tempResult = Integer.valueOf(stringBuffer.toString());
        int count = 1;
        if (tempResult < low) {
            if (tempResult % 10 == 9) {
                stringBuffer = new StringBuffer();
                for (int i = 0; i < ((tempResult + "").length() + 1); i++) {
                    if (((tempResult + "").length() + 1) > 9) {
                        return result;
                    } else
                        stringBuffer.append(i + 1);

                }
                tempResult = Integer.valueOf(stringBuffer.toString());
            } else {
                for (int i = 1; i < (tempResult + "").length(); i++) {
                    count = count * 10 + 1;
                }
                tempResult += count;
            }
            if (tempResult % 10 == 0)
                return result;
            if (tempResult <= high)
                result.add(tempResult);
            else
                return result;
        } else {
            if (tempResult % 10 == 0)
                return result;
            if (tempResult <= high)
                result.add(tempResult);
            else
                return result;
            for (int i = 1; i < (tempResult + "").length(); i++) {
                count = count * 10 + 1;
            }
        }
        while (tempResult < high) {
            if (tempResult % 10 != 9) {
                tempResult += count;
                if (tempResult % 10 == 0)
                    return result;
                if (tempResult >= low && tempResult <= high)
                    result.add(tempResult);
                else
                    break;
            } else {
                count = count * 10 + 1;
                stringBuffer = new StringBuffer("1");
                for (int i = 0; i < (tempResult + "").length(); i++) {
                    stringBuffer.append(i + 1);
                }
                tempResult = Integer.valueOf(stringBuffer.toString());
                tempResult += count / 10;
                if (tempResult % 10 == 0)
                    return result;
                if (tempResult >= low && tempResult <= high)
                    result.add(tempResult);
                else
                    break;
            }
        }
        return result;
    }

    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> result = new LinkedList();

        for (int m = 2; m <= 9 && Math.pow(10, m - 1) < high; m++) {
            for (int i = 1; i <= 8; i++) {
                int value = i;
                int j = i;
                while (++j - i < m && j < 10) {
                    value = value * 10 + j;
                }
                if (j - i == m && value >= low && value <= high) {
                    result.add(value);
                } else if (value > high) {
                    break;
                }
            }
        }

        return result;
    }

    public List<Integer> sequentialDigits3(int low, int high) {
        List<Integer> result = new LinkedList();
        String digits = "123456789";
        for (int i = 2; i <= 9; i++) {
            for (int m = 0, n = m + i; n <= 9; m++, n++) {
                int value = Integer.valueOf(digits.substring(m, n));
                if (value >= low && value <= high) {
                    result.add(value);
                } else if (value > high) {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        List<Integer> list = sequentialDigits.sequentialDigits2(100, 300);
        for (Integer o : list) {
            System.out.println(o.toString());
        }
    }

}
