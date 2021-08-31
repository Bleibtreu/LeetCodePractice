/**
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，
 * 字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 * <p>
 * 示例 1：
 * 输入：s = "AB"
 * 输出：4
 * <p>
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 *
 * @author bleibtreu
 * @date 2021/8/30
 */
public class QuickCalculationRobot {

    private final String A = "A";
    private final String B = "B";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        System.out.println(QuickCalculationRobot.class.newInstance().calculate("ABBBBAAAA"));
        System.out.println(QuickCalculationRobot.class.newInstance().calculate2("ABBBBAAAA"));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了6.60%的用户
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int res;
        int x = 1;
        int y = 0;
        String[] tempStrs;
        tempStrs = s.split("");
        for (String tempStr : tempStrs) {
            switch (tempStr) {
                case A:
                    x = A(x, y);
                    break;
                case B:
                    y = B(x, y);
                    break;
                default:
            }
        }
        res = x + y;
        return res;
    }

    private int A(int x, int y) {
        int res = 2 * x + y;
        return res;
    }

    private int B(int x, int y) {
        int res = 2 * y + x;
        return res;
    }

    /**
     * 不讲武德版
     * 执行用时： 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了95.46%的用户
     * @param s
     * @return
     */
    public int calculate2(String s) {
        return 1 << s.length();
    }
}

