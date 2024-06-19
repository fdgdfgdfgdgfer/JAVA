package org.example.java_base.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author jfz
 * @Date 2024/3/28 17:18
 * @PackageName:org.example.java_base.serializable
 * @ClassName: StudentA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentA implements Serializable {
    private Long serialVersionUID = -121544431345L;
    public String a;
    public String b;
}
