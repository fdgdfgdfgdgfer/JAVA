package org.example.JFrame;

import java.util.LinkedList;

/**
 * @Date 2019/3/28 20:25
 * @Created by mlt
 * @Description 蛇实体
 */
public class SnakeEntry {
    // 蛇身初始坐标
    private static LinkedList<CoordinateEntry> initialCoo;
    private static final int STOP_DIRECTION = 0b1111;
    // 蛇向上运动
    private static final int TOP_DIRECTION = 0b1000;
    // 蛇向右运动
    private static final int RIGHT_DIRECTION = 0b0100;
    // 蛇向下运动
    private static final int BOTTOM_DIRECTION = 0b0010;
    // 蛇向左运动
    private static final int LEFT_DIRECTION = 0x0001;
    // 单例的蛇
    private static SnakeEntry snakeEntry;
    // 初始长度
    private final int initSnakeSize = 7;
    // 速度变化阶梯
    private final int changeSpeed = 2;


    // 运动速度，多少毫秒运动一格
    private int moveSpeed;
    // 运动最小速度
    private final int minSpeed = 150;
    // 运动最大速度
    private final int maxSpeed = 50;
    // 运动方向
    private int motionDirection;
    // 蛇身所有坐标
    private LinkedList<org.example.JFrame.CoordinateEntry> snakeList;
    // 下次移动是否删除最后一个
    private boolean isRemove = true;

    /**
     * 单例蛇实体
     *
     * @param mapWidth  地图宽度
     * @param mapHeight 地图高度
     */
    private SnakeEntry(int mapWidth, int mapHeight) {
        initialCoo = new LinkedList<>();
        // 设置蛇身初始坐标
        for (int i = 0; i < initSnakeSize; i++) {
            initialCoo.add(new org.example.JFrame.CoordinateEntry(mapWidth / 2 - i, mapHeight / 2));
        }
        initData();
    }

    /**
     * 新建一个蛇
     *
     * @param mapWidth  地图宽度
     * @param mapHeight 地图高度
     */
    public static SnakeEntry newInstance(int mapWidth, int mapHeight) {
        if (snakeEntry == null) {
            snakeEntry = new SnakeEntry(mapWidth, mapHeight);
        }
        return snakeEntry;
    }

    /**
     * 数据初始化
     */
    private void initData() {
        motionDirection = RIGHT_DIRECTION;
        moveSpeed = minSpeed;
        if (snakeList == null) {
            snakeList = new LinkedList<>();
        }
        snakeList.clear();
        snakeList.addAll(initialCoo);
    }

    /**
     * 开始游戏
     */
    public void start() {
        initData();
    }

    /**
     * 计算下一步坐标
     */
    public org.example.JFrame.CoordinateEntry nextCoordinate(){
        org.example.JFrame.CoordinateEntry oldSnakeEntry = snakeList.get(0);
        org.example.JFrame.CoordinateEntry snakeEntry = new org.example.JFrame.CoordinateEntry(oldSnakeEntry.getCoordinate_x(), oldSnakeEntry.getCoordinate_y());
        int x = snakeEntry.getCoordinate_x();
        int y = snakeEntry.getCoordinate_y();
        switch (motionDirection) {
            case LEFT_DIRECTION:
                snakeEntry.setCoordinate_x(x - 1);
                break;
            case TOP_DIRECTION:
                snakeEntry.setCoordinate_y(y - 1);
                break;
            case RIGHT_DIRECTION:
                snakeEntry.setCoordinate_x(x + 1);
                break;
            case BOTTOM_DIRECTION:
                snakeEntry.setCoordinate_y(y + 1);
                break;
        }
        return snakeEntry;
    }

    /**
     * 移动
     * @return 是否成功
     */
    public boolean next() {
        org.example.JFrame.CoordinateEntry snakeEntry = nextCoordinate();
        int x = snakeEntry.getCoordinate_x();
        int y = snakeEntry.getCoordinate_y();
        switch (motionDirection) {
            case LEFT_DIRECTION:
                if (x < 0) {
                    return false;
                }
                break;
            case TOP_DIRECTION:
                if (y < 0) {
                    return false;
                }
                break;
            case RIGHT_DIRECTION:
                if (x >= org.example.JFrame.MapEntry.getMapWidth()) {
                    return false;
                }
                break;
            case BOTTOM_DIRECTION:
                if (y >= org.example.JFrame.MapEntry.getMapHeight()) {
                    return false;
                }
                break;
        }
        snakeList.add(0, snakeEntry);
        if (isRemove) {
            snakeList.removeLast();
        }
        isRemove = true;
        return true;
    }

    /**
     * 判断是否撞到自己
     * @param newCoordinate 下一个坐标
     * @return 是否撞到自己
     */
    public boolean isRamSelf(org.example.JFrame.CoordinateEntry newCoordinate){
        for (org.example.JFrame.CoordinateEntry coordinateEntry : snakeList) {
            if (coordinateEntry.isRam(newCoordinate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否撞击
     *
     * @param snakeEntry 新的坐标
     */
    public boolean isRam(org.example.JFrame.CoordinateEntry snakeEntry) {
        org.example.JFrame.CoordinateEntry coordinateEntry = snakeList.get(0);
        return coordinateEntry.isRam(snakeEntry);
    }

    /**
     * 尾部增加一个
     */
    public void addSnakeSize() {
        isRemove = false;
    }

    /**
     * 根据长度判断速度
     */
    public void nextSpeed() {
        int size = snakeList.size();
        for (int i = 0; moveSpeed > maxSpeed; i++) {
            if (size <= initSnakeSize + changeSpeed * i) {
                moveSpeed = minSpeed - (20 * i);
                break;
            }
        }
    }

    /**
     * @return 运动速度
     */
    public int getMoveSpeed() {
        return moveSpeed;
    }

    public LinkedList<org.example.JFrame.CoordinateEntry> getSnakeList() {
        return snakeList;
    }

    /**
     * 运动方向
     */
    public void setDirectionLeft() {
        org.example.JFrame.CoordinateEntry firstCoo = snakeList.get(0);
        org.example.JFrame.CoordinateEntry two = snakeList.get(1);
        if (firstCoo.getCoordinate_x() - two.getCoordinate_x() == 1) {
            return;
        }
        motionDirection = LEFT_DIRECTION;
    }

    public void setDirectionRight() {
        org.example.JFrame.CoordinateEntry firstCoo = snakeList.get(0);
        org.example.JFrame.CoordinateEntry two = snakeList.get(1);
        if (firstCoo.getCoordinate_x() - two.getCoordinate_x() == -1) {
            return;
        }
        motionDirection = RIGHT_DIRECTION;
    }

    public void setDirectionTop() {
        org.example.JFrame.CoordinateEntry firstCoo = snakeList.get(0);
        org.example.JFrame.CoordinateEntry two = snakeList.get(1);
        if (firstCoo.getCoordinate_y() - two.getCoordinate_y() == 1) {
            return;
        }
        motionDirection = TOP_DIRECTION;
    }

    public void setDirectionBottom() {
        org.example.JFrame.CoordinateEntry firstCoo = snakeList.get(0);
        org.example.JFrame.CoordinateEntry two = snakeList.get(1);
        if (firstCoo.getCoordinate_y() - two.getCoordinate_y() == -1) {
            return;
        }
        motionDirection = BOTTOM_DIRECTION;
    }
}