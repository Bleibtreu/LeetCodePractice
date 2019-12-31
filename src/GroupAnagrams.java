import java.util.*;

/**
 * Created by Bleibtreu on 2019/12/31 10:45
 */
public class GroupAnagrams {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(GroupAnagrams.class.newInstance().groupAnagrams(strings));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap<String,List>();
        for(String i:strs){
            char[] arr=i.toCharArray();
            Arrays.sort(arr);
            String str=String.valueOf(arr);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList());
            }
            map.get(str).add(i);
        }
        return new ArrayList(map.values());
    }
}
