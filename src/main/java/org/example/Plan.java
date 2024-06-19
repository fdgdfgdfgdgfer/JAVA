package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plan extends JFrame implements KeyListener {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int PLAYER_SPEED = 5;
    private final int ENEMY_SPEED = 3;
    private final int BULLET_SPEED = 7;

    private boolean isRunning = true;
    private boolean isShooting = false;

    private int playerX = WIDTH / 2;
    private int playerY = HEIGHT - 100;
    private List<Integer> bulletsX = new ArrayList<>();
    private List<Integer> bulletsY = new ArrayList<>();
    private List<Integer> enemyX = new ArrayList<>();
    private List<Integer> enemyY = new ArrayList<>();

    public Plan() {
        setTitle("Airplane Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addKeyListener(this);

        spawnEnemies();

        while (isRunning) {
            movePlayer();
            moveBullets();
            moveEnemies();
            checkCollisions();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void spawnEnemies() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            enemyX.add(random.nextInt(WIDTH));
            enemyY.add(random.nextInt(200) - 400);
        }
    }

    private void movePlayer() {
        if (isShooting) {
            bulletsX.add(playerX);
            bulletsY.add(playerY);
            isShooting = false;
        }
    }

    private void moveBullets() {
        for (int i = 0; i < bulletsY.size(); i++) {
            bulletsY.set(i, bulletsY.get(i) - BULLET_SPEED);
            if (bulletsY.get(i) < 0) {
                bulletsX.remove(i);
                bulletsY.remove(i);
            }
        }
    }

    private void moveEnemies() {
        for (int i = 0; i < enemyY.size(); i++) {
            enemyY.set(i, enemyY.get(i) + ENEMY_SPEED);
            if (enemyY.get(i) > HEIGHT) {
                enemyX.set(i, new Random().nextInt(WIDTH));
                enemyY.set(i, -200);
            }
        }
    }

    private void checkCollisions() {
        Rectangle playerRect = new Rectangle(playerX, playerY, 50, 50);
        for (int i = 0; i < enemyX.size(); i++) {
            Rectangle enemyRect = new Rectangle(enemyX.get(i), enemyY.get(i), 50, 50);
            if (playerRect.intersects(enemyRect)) {
                isRunning = false;
                JOptionPane.showMessageDialog(this, "Game Over! Your Score: " + (enemyX.size() - 5));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50);

        g.setColor(Color.RED);
        for (int i = 0; i < bulletsX.size(); i++) {
            g.fillRect(bulletsX.get(i), bulletsY.get(i), 5, 10);
        }
        g.setColor(Color.GREEN);
        for (int i = 0; i < enemyX.size(); i++) {
            g.fillRect(enemyX.get(i), enemyY.get(i), 50, 50);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && playerX > 0) {
            playerX -= PLAYER_SPEED;
        }
        if (key == KeyEvent.VK_RIGHT && playerX < WIDTH - 50) {
            playerX += PLAYER_SPEED;
        }
        if (key == KeyEvent.VK_SPACE) {
            isShooting = true;
        }
    }






    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new Plan();
    }

}