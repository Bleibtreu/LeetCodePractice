import java.util.HashSet;
import java.util.Set;

/**
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。
 * 作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。
 * 要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，
 * 其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 *
 * 示例：
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 *
 * 提示：
 * len(solution) = len(guess) = 4
 * solution和guess仅包含"R","G","B","Y"这4种字符
 *
 * Created by Bleibtreu on 2020/8/10 16:14
 */
public class MasterMind {

    public int[] masterMind1(String solution, String guess) {
        int[] result = {0,0};
        byte[] sol = solution.getBytes();
        byte[] gue = guess.getBytes();
        Set hashSet = new HashSet();
        hashSet.add(sol[0]);
        hashSet.add(sol[1]);
        hashSet.add(sol[2]);
        hashSet.add(sol[3]);
        for (int i = 0; i < 4; i++) {
            if (sol[i] == gue[i]) {
                result[0]++;
                continue;
            }
            if(!hashSet.add(gue[i])) {
                result[1]++;
            }
        }
        return result;
    }

    public int[] masterMind2(String solution, String guess) {
        int[] counter = new int[4];
        int match = 0, count = 0;
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i))
                match++;
            counter[getIdx(solution.charAt(i))]++;
        }
        for (int i = 0; i < 4; i++)
            if (--counter[getIdx(guess.charAt(i))] >= 0)
                count++;
        return new int[]{match, count - match};
    }

    public int getIdx(char ch) {
        if (ch == 'R')
            return 0;
        else if (ch == 'G')
            return 1;
        else if (ch == 'B')
            return 2;
        else
            return 3;
    }

    public static void main(String[] args) {
        MasterMind masterMind = new MasterMind();
        int[] res = masterMind.masterMind2("RGBY", "GGRR");
        System.out.println(res[0] + ", " + res[1]);
    }
}
