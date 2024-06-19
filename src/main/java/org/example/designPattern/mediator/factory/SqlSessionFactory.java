package org.example.designPattern.mediator.factory;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.mediator.configuration.Configuration;
import org.example.designPattern.mediator.operate.MybatiosSqlSessionFactory;

/**
 * @Author jfz
 * @Date 2024/3/6 16:16
 * @PackageName:org.example.designPattern.mediator.factory
 * @ClassName: SqlFactory
 */
@Data
@NoArgsConstructor
public class SqlSessionFactory implements MybatiosSqlSessionFactory {
    private Configuration configuration;

    public SqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new SqlSession(configuration.connection, configuration.mapper);
    }
}
