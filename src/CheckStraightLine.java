/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
 * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 示例 1：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 示例 2：
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 *
 * Created by Bleibtreu on 2020/7/22 9:41
 */
public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (2 > coordinates.length || coordinates.length > 1000) return false;

        for (int i = 0; i < coordinates.length - 2; i++) {
            if (coordinates[i].length != 2) return false;
            if (-10000 > coordinates[i][0] || coordinates[i][1] > 10000) return false;
            if((coordinates[i+1][1] - coordinates[i][1]) * (coordinates[i+2][0] - coordinates[i+1][0])
                    != (coordinates[i+2][1] - coordinates[i+1][1]) * (coordinates[i+1][0] - coordinates[i][0]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckStraightLine checkStraightLine = new CheckStraightLine();
        int [][] coordinates = {{0,0},{0,1},{3,4},{4,5},{5,6},{6,7}};

        System.out.println(checkStraightLine.checkStraightLine(coordinates));
    }

}
