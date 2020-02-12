import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bleibtreu on 2020/1/20 11:05
 */
public class DiffWaysToCompute {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        List<Integer> list = DiffWaysToCompute.class.newInstance().diffWaysToCompute("2*789089887-4*5");
        List<Integer> list2 = DiffWaysToCompute.class.newInstance().diffWaysToCompute2("2-1-1");
        for (Integer i : list2) {
            System.out.println(i);
        }
    }

    public List diffWaysToCompute(String input) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList();
        String temp = "";
        map.put("+",0);
        map.put("-",0);
        map.put("*",0);
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(String.valueOf(input.toCharArray()[i]))) {
                if (!temp.equals("")) {
                    list.add(Integer.valueOf(temp));
                    temp = "";
                }
                map.replace(String.valueOf(input.toCharArray()[i]), map.get(String.valueOf(input.toCharArray()[i])) + 1);
            } else {
                temp += String.valueOf(input.toCharArray()[i]);
            }
            if (i == input.length() - 1) list.add(Integer.valueOf(temp));
        }
        return list;
    }


    public Map<String, List<Integer>> map = new HashMap<>();
    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public List<Integer> diffWaysToCompute2(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {  // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute2(input.substring(0, i));
                List<Integer> right = diffWaysToCompute2(input.substring(i+1, input.length()));
                // -1   =>  left:[[0]]  right:[[1]]

                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(input));
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;
    }

}
