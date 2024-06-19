package org.example.java_base.copy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 15:20
 * @PackageName:org.example.java_base.copy
 * @ClassName: SerializeWayDoCope
 */

public class SerializeWayDoCope {
    public static void main(String[] args) {

        SerializeModel serializeModelOne = new SerializeModel();
        SerializeModel serializeModelTwo = serializeModelOne.clone();
        System.out.println(serializeModelTwo==serializeModelOne);
        System.out.println(serializeModelOne.prent == serializeModelTwo.prent);

    }
}
