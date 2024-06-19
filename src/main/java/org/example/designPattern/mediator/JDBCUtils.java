package org.example.designPattern.mediator;


import org.example.designPattern.mediator.factory.SqlSession;
import org.example.designPattern.mediator.factory.SqlSessionFactory;
import org.example.designPattern.mediator.factory.SqlSessionFactoryBuild;
import org.example.designPattern.mediator.resour.Resours;

import java.io.Reader;


/**
 * @Author jfz
 * @Date 2024/3/6 14:19
 * @PackageName:org.example.designPattern.mediator
 * @ClassName: JDBCUtils
 */

public class JDBCUtils {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/fmmall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "jsq123456";

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        Reader reader;

        reader = Resours.getResourceAsReader(resource);
        SqlSessionFactory sqlMapper = new
                SqlSessionFactoryBuild().build(reader);
        SqlSession session = sqlMapper.openSession();

    }
}
