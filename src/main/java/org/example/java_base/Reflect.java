package org.example.java_base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/28 16:33
 * @PackageName:org.example.java_base
 * @ClassName: Reflect
 */
@Data
@NoArgsConstructor
@Builder
public class Reflect {
    private String a;
    public String b;

    public Reflect(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public String setB(String b) {
        this.b = b;
        return b;
    }
}
