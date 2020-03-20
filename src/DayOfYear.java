/**
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。
 * 每个月的天数与现行公元纪年法（格里高利历）一致。
 * 示例 1：
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 * 输入：date = "2019-02-10"
 * 输出：41
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * Created by Bleibtreu on 2020/3/20 9:35
 */
public class DayOfYear {
    public int dayOfYear(String date) {
        if (date.length() != 10)
            return 0;
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int[] days_of_month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int result = day;
        switch (month) {
            case 1: return result;
            case 2: return result + days_of_month[0];
            default:break;
        }
        for (int i = 0; i < days_of_month.length; i++) {
            if (i == month - 1)
                break;
            result += days_of_month[i];
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {    //365
            return result + 1;
        } else {//366
            return result;
        }
    }

    /**
     * 对于题来说，很酷，内存消耗第一名答案
     * @param date
     * @return
     */
    public int dayOfYear2(String date) {
        int num = 0;
        String[]dateArray= date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);
        boolean runnian = false;
        if((year%4==0 && year%100 != 0) || year%400==0 ){
            runnian = true;
        }
        num += day;
        month--;
        for(int i= month;i>0;i--){
            switch (i){
                case 1:num += 31;
                    break;
                case 2:
                    if(runnian) {
                        num += 29;
                        break;
                    }else {num += 28;
                        break;}
                case 3:num += 31;
                    break;
                case 4:num += 30;
                    break;
                case 5:num += 31;
                    break;
                case 6:num+=30;
                    break;
                case 7:num += 31;
                    break;
                case 8:num += 31;
                    break;
                case 9:num += 30;
                    break;
                case 10:num += 31;
                    break;
                case 11:num += 30;
                    break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        System.out.println(dayOfYear.dayOfYear("2016-02-29"));
    }
}
