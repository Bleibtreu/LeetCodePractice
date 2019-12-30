import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bleibtreu on 2019/12/20 15:46
 */
public class OccurrencesAfterBigram {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String[] temp = OccurrencesAfterBigram.class.newInstance().findOcurrences("ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv ypkk", "lnlqhmaohv", "ypkk");
        for (String i : temp) {
            System.out.println(i);
        }
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] temp;
        List<String> result = new ArrayList<>();
        temp = text.split(" ");
        for (int i = 0; i < temp.length; i++) {
            if (i + 2 >= temp.length) break;
            if (temp[i].equals(first)  && temp[i + 1].equals(second)) {
                result.add(temp[i + 2]);
                System.out.println(temp[i + 2]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
