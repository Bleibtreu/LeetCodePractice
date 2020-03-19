/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 *      输入：2
 *      输出：1
 *      解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *      输入：3
 *      输出：2
 *      解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *      输入：4
 *      输出：3
 *      解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 提示：
 *      0 ≤ N ≤ 30
 *
 * Created by Bleibtreu on 2020/3/19 10:34
 */
public class Fib {
    /**
     * 复杂度分析
     * 时间复杂度：O(2^N)这是计算斐波那契数最慢的方法。因为它需要指数的时间。
     * 空间复杂度：O(N)，在堆栈中我们需要与 N 成正比的空间大小。
     * 该堆栈跟踪 fib(N) 的函数调用，随着堆栈的不断增长如果没有足够的内存则会导致 StackOverflowError。
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N ==1)
            return 1;
        return fib(N-1) + fib(N-2);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(4));
    }
}
