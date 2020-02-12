/**
 * Created by Bleibtreu on 2019/12/31 17:42
 */
public class Pow {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(Pow.class.newInstance().myPow(2.00000, 10));
    }
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
            n = Math.abs(n);
        }
        double result = 0;
        for (int i = 0; i < n; i++) {
            x = x * x;
            result = x;
        }
        return result;
    }
}
