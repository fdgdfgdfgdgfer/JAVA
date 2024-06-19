package org.example.java_base.copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 14:56
 * @PackageName:org.example.java_base
 * @ClassName: DeepCopy
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepModel shallowOne = new DeepModel("shallow", new Prent());
        DeepModel shallowTwo = shallowOne.clone();
        System.out.println(shallowOne);
        System.out.println(shallowTwo);
        System.out.println(shallowOne==shallowTwo);
        System.out.println(shallowOne.getPrent() == shallowTwo.getPrent());
    }
}
