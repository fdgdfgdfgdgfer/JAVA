package org.example.JFrame;

import  org.example.JFrame.CoordinateEntry;
import  org.example.JFrame.FootEntry;
import  org.example.JFrame.MapEntry;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * @Date 2019/3/27 21:53
 * @Created by mlt
 * @Description 贪吃蛇主窗口
 */
public class MainWindow extends JFrame implements Runnable {
    // 地图宽度
    private int WINDOW_WIDTH = 600;
    // 地图宽度
    private int WINDOW_HEIGHT = 600;
    // 物体坐标
    private static int addressX = 300;
    private static int addressY = 300;
    // 物体大小
    private static int ROLE_SIZE = 8;
    // 上次移动时间
    private long moveTime = -1;
    // 是否运行
    private boolean isRuing;
    // 运行线程
    private boolean isRunThread;
    // 蛇实体
    private SnakeEntry snakeEntry;
    // 食物实体
    private FootEntry footEntry;


    private JPanel canvas;
    private JLabel jLabel;


    public MainWindow() {
        super("贪吃蛇");
        // 初始化窗口
        initWindow();
        // 初始化数据
        initData();
    }

    /**
     * 初始化窗口
     */
    private void initWindow() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rectangle = graphicsEnvironment.getMaximumWindowBounds();
        // 设置窗口宽高
        while (ROLE_SIZE * MapEntry.getMapWidth() + 20 > rectangle.width
                | ROLE_SIZE * MapEntry.getMapHeight() > rectangle.height) {
            ROLE_SIZE--;
        }

        WINDOW_WIDTH = ROLE_SIZE * MapEntry.getMapWidth();
        WINDOW_HEIGHT = ROLE_SIZE * MapEntry.getMapHeight();

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT + 20);
        // 隐藏标题栏
        setUndecorated(true);
        // 获取屏幕宽高
        setLocation(rectangle.width / 2 - (WINDOW_WIDTH / 2), rectangle.height / 2 - (WINDOW_HEIGHT / 2));
        // 设置关闭窗口操作也关闭程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLayout(null);
        // 添加关闭按钮
        jLabel = new JLabel("X", JLabel.CENTER);
        // 设置位置及大小
        jLabel.setBounds(WINDOW_WIDTH - 50, 0, 50, 20);
        // 设置为不透明，因为默认是透明的。。。
        jLabel.setOpaque(true);
        // 设置背景颜色
        jLabel.setBackground(Color.WHITE);
        jLabel.setForeground(Color.BLACK);
        jLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 处理鼠标点击
            }

            public void mouseEntered(MouseEvent e) {
                // 处理鼠标移入
                jLabel.setBackground(Color.RED);
                jLabel.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                // 处理鼠标离开
                jLabel.setBackground(Color.WHITE);
                jLabel.setForeground(Color.BLACK);
            }

            public void mousePressed(MouseEvent e) {
                // 处理鼠标按下
            }

            public void mouseReleased(MouseEvent e) {
                // 处理鼠标释放
                dispose();
            }
        });
        add(jLabel);
        // 添加标题
        JLabel title = new JLabel("贪吃蛇");
        // 设置位置及大小
        title.setBounds(10, 0, WINDOW_WIDTH / 2, 20);
        add(title);
        // 添加画图空间 Canvas控件会阻止键盘监听
        canvas = new Paint();
//        canvas.setVisible(false);
        canvas.setBounds(0, 20, WINDOW_WIDTH, WINDOW_HEIGHT);
        add(canvas);
        // 添加窗口焦点事件
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 窗口获得焦点
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 窗口失去焦点
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 输入按键
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 按下按键,长按循环调用
//                System.out.println(e.getKeyCode());
                // 点击按键控制位置
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        snakeEntry.setDirectionLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        snakeEntry.setDirectionRight();
                        break;
                    case KeyEvent.VK_UP:
                        snakeEntry.setDirectionTop();
                        break;
                    case KeyEvent.VK_DOWN:
                        snakeEntry.setDirectionBottom();
                        break;
                    case KeyEvent.VK_SPACE:
                        if (!isRuing) {
                            isRuing = true;
                            snakeEntry.start();
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 松开按键
            }
        });

        addWindowListener(new WindowAdapter() {
            /**
             * 关闭窗口监听
             */
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                isRunThread = false;
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initData() {
        snakeEntry = SnakeEntry.newInstance(MapEntry.getMapWidth(), MapEntry.getMapHeight());
        isRunThread = true;
        footEntry = FootEntry.newInstance();
        new Thread(this).start();
    }

    /**
     * 计算
     */
    private void handleData() {
        if (!isRuing) {
            return;
        }
        long time = System.currentTimeMillis();
        if (time - moveTime > snakeEntry.getMoveSpeed()) {
            CoordinateEntry snakeCoo = snakeEntry.nextCoordinate();
            // 计算果实位置
            if (snakeCoo.isRam(footEntry.getCoordinateEntry())) {
                snakeEntry.addSnakeSize();
                footEntry.next();
            }
            if (snakeEntry.isRamSelf(snakeCoo)) {
                isRuing = false;
                return;
            }
            isRuing = snakeEntry.next();
            snakeEntry.nextSpeed();
            moveTime = time;
        }
    }

    @Override
    public void run() {
        try {
            moveTime = System.currentTimeMillis();
            while (isRunThread) {
                handleData();
                canvas.repaint();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class Paint extends JPanel {
        @Override
        public void paint(Graphics gr) {
            super.paint(gr);
            Graphics2D g = (Graphics2D) gr;
            // 画图
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.WHITE);
            LinkedList<CoordinateEntry> snakeList = snakeEntry.getSnakeList();
            for (int i = 0; i < snakeList.size(); i++) {
                CoordinateEntry coordinateEntry = snakeList.get(i);
                g.fillRect(coordinateEntry.getCoordinate_x() * ROLE_SIZE
                        , coordinateEntry.getCoordinate_y() * ROLE_SIZE
                        , ROLE_SIZE
                        , ROLE_SIZE);
            }
            g.setColor(Color.WHITE);
            CoordinateEntry footCoo = footEntry.getCoordinateEntry();
            g.fillRect(footCoo.getCoordinate_x() * ROLE_SIZE
                    , footCoo.getCoordinate_y() * ROLE_SIZE
                    , ROLE_SIZE
                    , ROLE_SIZE);
        }
    }
}