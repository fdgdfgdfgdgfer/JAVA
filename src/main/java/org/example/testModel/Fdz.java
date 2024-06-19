package org.example.testModel;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @Author jfz
 * @Date 2024/5/27 17:17
 * @PackageName:org.example.testModel
 * @ClassName: Fdz
 */
public class Fdz {
    public static List<String> p = new ArrayList<>();

    static {
        p.add("‍👤A");
        p.add("‍👤10");
        p.add("‍👤2");
        p.add("‍👤3");
        p.add("‍👤4");
        p.add("‍👤5");
        p.add("‍👤6");
        p.add("‍👤7");
        p.add("‍👤8");
        p.add("‍👤9");
        p.add("‍👤J");
        p.add("‍👤Q");
        p.add("‍👤K");
        p.add("‍👤w");


        p.add("‍🦊A");
        p.add("🦊10");
        p.add("🦊2");
        p.add("🦊3");
        p.add("🦊4");
        p.add("🦊5");
        p.add("🦊6");
        p.add("🦊7");
        p.add("🦊8");
        p.add("🦊9");
        p.add("🦊J");
        p.add("🦊Q");
        p.add("🦊K");

        p.add("‍🐞A");
        p.add("🐞10");
        p.add("🐞2");
        p.add("🐞3");
        p.add("🐞4");
        p.add("🐞5");
        p.add("🐞6");
        p.add("🐞7");
        p.add("🐞8");
        p.add("🐞9");
        p.add("🐞J");
        p.add("🐞Q");
        p.add("🐞K");


        p.add("‍🦞A");
        p.add("‍🦞10");
        p.add("‍🦞2");
        p.add("‍🦞3");
        p.add("‍🦞4");
        p.add("‍🦞5");
        p.add("‍🦞6");
        p.add("‍🦞7");
        p.add("‍🦞8");
        p.add("‍🦞9");
        p.add("‍🦞J");
        p.add("‍🦞Q");
        p.add("‍🦞K");
        p.add("‍🦞W");


    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------dtz------Y/N?");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.equals("N")) {
            return;
        }
        if (next.equals("Y")) {
            DdzImpl ddz = new DdzImpl();
            //准备阶段
            new Brigh(ddz) {
                @Override
                public void process() {
                    ddz.begin(p);
                }
            }.process();
            //抢地主
            new Brigh(ddz) {
                @Override
                public void process() throws InterruptedException {
                    ddz.figDz();
                }
            }.process();

            //出牌
            new Brigh(ddz) {
                @Override
                public void process() throws InterruptedException {
                    ddz.out();
                }
            }.process();
        } else {
            System.out.println("输入错误...");
            return;
        }
    }
}
