package org.example.JFrame;

/**
 * @Date 2019/3/28 20:25
 * @Created by mlt
 * @Description 地图
 */
public class MapEntry {
    private static final int mapWidth = 100;
    private static final int mapHeight = 100;

    public static int getMapWidth() {
        return mapWidth;
    }

    public static int getMapHeight() {
        return mapHeight;
    }

    public static int getMapMinX() {
        return 0;
    }

    public static int getMapMinY() {
        return 0;
    }

    public static int getCoreX(){
        return mapWidth / 2;
    }

    public static int getCoreY(){
        return mapHeight / 2;
    }
}