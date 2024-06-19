package org.example.concurrent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/5/22 15:37
 * @PackageName:org.example.concurrent
 * @ClassName: Person
 */

public class Person {
    public static void main(String[] args) {
        Mic mic = new Mic();
        //听音乐
        Thread thread = new Thread(mic);
        //看视频
        new Thread(new Vidio());
        //看直播
        new Thread(new Live());
    }
    static class Mic implements Runnable {
        @Override
        public void run() {

            System.out.println("我在听音乐...");
        }
    }
    static class Vidio implements Runnable {
        @Override
        public void run() {
            System.out.println("我在看视频...");
        }
    }
    static class Live implements Runnable {
        @Override
        public void run() {
            System.out.println("我在看直播...");
        }
    }
}
