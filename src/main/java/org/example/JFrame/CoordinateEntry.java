package org.example.JFrame;

/**
 * @Date 2019/3/28 20:34
 * @Created by mlt
 * @Description 坐标实体
 */
public class CoordinateEntry {
    private int coordinate_x;
    private int coordinate_y;

    public CoordinateEntry() {
        this.coordinate_x = 0;
        this.coordinate_y = 0;
    }

    public CoordinateEntry(int coordinate_x, int coordinate_y) {
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    /**
     * 判断是否撞击
     * @param entry 需要判断的坐标
     */
    public boolean isRam(CoordinateEntry entry) {
        return coordinate_x == entry.coordinate_x && coordinate_y == entry.coordinate_y;
    }

    @Override
    public String toString() {
        return "X坐标为：" + coordinate_x + "--- Y坐标为：" + coordinate_y;
    }
}