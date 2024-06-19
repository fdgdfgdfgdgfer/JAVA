package org.example.designPattern.mediator.operate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.mediator.factory.SqlSession;

/**
 * @Author jfz
 * @Date 2024/3/6 16:23
 * @PackageName:org.example.designPattern.mediator.operate
 * @ClassName: SqlSessionFactory
 */

public interface MybatiosSqlSessionFactory {
    SqlSession  openSession();
}
