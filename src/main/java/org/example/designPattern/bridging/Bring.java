package org.example.designPattern.bridging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/7 17:21
 * @PackageName:org.example.designPattern.bridging
 * @ClassName: Bring
 */
public class Bring {
    public static void main(String[] args) {
        Lyq lyq = new Lyq(new Mouth());
        System.out.println( lyq.show());


        Lyq lyq1 = new Lyq(new Guild());
        System.out.println(lyq1.commonAc.show());

    }
}
