package org.example.designPattern.piping.cover;

/**
 * @Author jfz
 * @Date 2024/6/7 10:04
 * @PackageName:org.example.designPattern.factory
 * @ClassName: CoverMain
 */
public class CoverMain {
    public static void main(String[] args) {
        BuildService buildService = new BuildService();
        Object build = buildService.build();
    }
}
