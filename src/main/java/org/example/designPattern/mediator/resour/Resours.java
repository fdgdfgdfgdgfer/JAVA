package org.example.designPattern.mediator.resour;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @Author jfz
 * @Date 2024/3/6 16:17
 * @PackageName:org.example.designPattern.mediator.resour
 * @ClassName: Resours
 */
@Data
@NoArgsConstructor
public class Resours {
    //获取xml文件
    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    private static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader classLoader : classLoaders) {
            InputStream resourceAsStream = classLoader.getResourceAsStream(resource);
            if (null != resourceAsStream) {
                return resourceAsStream;
            }
        }
        throw new IOException("could not find resource " + resource);
    }

    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(), Thread.currentThread().getContextClassLoader()
        };
    }


}
