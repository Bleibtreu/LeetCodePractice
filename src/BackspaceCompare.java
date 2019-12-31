import java.util.Stack;

/**
 * Created by Bleibtreu on 2019/12/31 10:14
 */
public class BackspaceCompare {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(BackspaceCompare.class.newInstance().backspaceCompare("a#c","b"));
    }
    public boolean backspaceCompare(String t,String s) {
        Stack<Character> tStack = new Stack<Character>();
        Stack<Character> sStack = new Stack<Character>();
        for (char i : t.toCharArray()) {
            if (i == "#".charAt(0)) {
                if (tStack.empty()) continue;
                else tStack.pop();
            } else tStack.push(i);
        }
        for (char i : s.toCharArray()) {
            if (i == "#".charAt(0)) {
                if (sStack.empty()) continue;
                else sStack.pop();
            } else sStack.push(i);
        }
        if (tStack.toString().equals(sStack.toString())) return true;
        else return false;
    }
}
