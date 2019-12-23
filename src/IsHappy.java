public class IsHappy {

    public static void main(String[] args) {
        IsHappy main = new IsHappy();
        System.out.println(main.isHappy(19));
    }

    public boolean isHappy(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int result = 0;
        int num = 0;
        if (n != 0) {
            for (int i = 0; i < chars.length; i++) {
                num = n % 10;
                n = n / 10;
                result = result + num * num;
            }
        }
        if (result == 1) return true;

        if (result < Integer.MAX_VALUE) isHappy(result);

        return false;
    }

}
