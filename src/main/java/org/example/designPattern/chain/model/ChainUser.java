package org.example.designPattern.chain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/4 9:23
 * @PackageName:org.example.designPattern.chain.model
 * @ClassName: ChainOpt
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChainUser {
    private String uid;
    private String name;
    private String userType;
}
