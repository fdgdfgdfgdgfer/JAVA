package org.example.designPattern.mediator.factory;

import static org.junit.Assert.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.mediator.model.User;
import org.example.designPattern.mediator.resour.Resours;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author jfz
 * @Date 2024/3/7 10:07
 * @PackageName:org.example.designPattern.mediator.factory
 * @ClassName: SqlSessionFactoryBuildTest
 */

public class SqlSessionFactoryBuildTest {

    @Test
    public void sqlSession() throws Exception {

        //获取xml数据
        Reader resourceAsReader = Resours.getResourceAsReader("mybatis-config.xml");

        SqlSession sqlSession = new SqlSessionFactoryBuild().build(resourceAsReader).openSession();

        User o = sqlSession.selectOne("org.example.designPattern.mediator.dto.UserMapper.selectOne");

        System.out.println(o);
    }
}