package org.example.JFrame;

/**
 * @Date 2019/4/4 19:39
 * @Created by mlt
 * @Description 食物
 */
public class FootEntry {
    // 单例食物
    private static FootEntry footEntry;

    // 坐标
    private CoordinateEntry coordinateEntry;

    private FootEntry(CoordinateEntry coordinateEntry) {
        this.coordinateEntry = coordinateEntry;
    }

    public static FootEntry newInstance() {
        if (footEntry == null) {
            footEntry = new FootEntry(
                    new CoordinateEntry((int) (Math.random() * MapEntry.getMapWidth())
                            , (int) (Math.random() * MapEntry.getMapHeight())));
        }
        return footEntry;
    }

    /**
     * 计算下一个食物坐标
     */
    public void next() {
        coordinateEntry.setCoordinate_x((int) (Math.random() * MapEntry.getMapWidth()));
        coordinateEntry.setCoordinate_y((int) (Math.random() * MapEntry.getMapHeight()));
    }

    // 获取坐标
    public CoordinateEntry getCoordinateEntry() {
        return coordinateEntry;
    }
}