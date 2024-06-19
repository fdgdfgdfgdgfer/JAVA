package org.example.designPattern.mediator.operate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/6 16:17
 * @PackageName:org.example.designPattern.mediator.operate
 * @ClassName: MybaitsOperation
 */

public interface MybaitsOperation {
    <T> T selectOne(String statement);
}
