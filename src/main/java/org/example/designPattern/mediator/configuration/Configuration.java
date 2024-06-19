package org.example.designPattern.mediator.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.mediator.model.XNode;

import java.sql.Connection;
import java.util.Map;

/**
 * @Author jfz
 * @Date 2024/3/6 16:16
 * @PackageName:org.example.designPattern.mediator.configuration
 * @ClassName: Configuration
 */
@Data
@NoArgsConstructor
public class Configuration {
    //mapper的sql操作
    public Map<String, XNode> mapper;
    //数据库连接
    public Connection connection;
    //数据库连接信息
    public Map<String, String> dataSour;

    public void setMapper(Map<String, XNode> mapper) {
        this.mapper = mapper;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSour(Map<String, String> dataSour) {
        this.dataSour = dataSour;
    }
}
