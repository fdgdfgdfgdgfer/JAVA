package org.example.concurrent;

import lombok.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Author jfz
 * @Date 2024/5/7 14:46
 * @PackageName:org.example.concurrent
 * @ClassName: Game
 */

public class Game {
    static volatile Boolean loop = false;

    public static void main(String[] arg) throws InterruptedException {

        new Thread(
                new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        while (true) {
                            if (loop) {
                                System.out.println("I LOVE YOU FOREVER MZ");
                                break;
                            }
                        }
                    }
                }

        ).start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("点击计入game,Y/N");
        String number = scanner.next();
        if ("Y".equals(number)) {
            System.out.println("les go!!!");
            while (true) {
                Integer a1 = (int) (Math.random() * 100);
                Integer a2 = (int) (Math.random() * 100);
                System.out.println("请问" + a1 + "+" + a2 + "等于？  ____");
                int a = scanner.nextInt();

                while (a != a1 + a2) {
                    System.out.println("回答失败！请重试");
                    System.out.println("请问" + a1 + "+" + a2 + "等于？  ____");
                    a = scanner.nextInt();
                }
                System.out.println("回答正确！");
                System.out.println("继续? Y/N");
                String am = scanner.next();
                if (am.equals("N")) {
                    break;
                }
                System.out.println("幸运词______");
                String fun = scanner.next();
                if (fun.equals("gmz")) {
                    loop = true;
                    TimeUnit.SECONDS.sleep(1);
                    break;
                }
            }
            System.out.println("退出！");
        }
        scanner.close();
    }
}