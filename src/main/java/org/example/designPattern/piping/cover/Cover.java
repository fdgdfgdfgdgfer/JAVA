package org.example.designPattern.piping.cover;

import org.example.designPattern.factory.ReqContext;
import org.springframework.beans.BeanUtils;

/**
 * @Author jfz
 * @Date 2024/6/7 9:56
 * @PackageName:org.example.designPattern.factory
 * @ClassName: Cover
 */
public class Cover implements CoverInput {


    @Override
    public void copy(Object o, Object o2) {
        ReqContext reqContext = null;
        Context context = null;
        if (o instanceof ReqContext) {
            reqContext = (ReqContext) o;
        }
        if (o2 instanceof Context) {
            context = (Context) o2;
        }
        BeanUtils.copyProperties(reqContext, context);
    }
}
