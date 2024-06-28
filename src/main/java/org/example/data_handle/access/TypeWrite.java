package org.example.data_handle.access;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;

public abstract class TypeWrite {
    //最大行数
    public final static Long MAX_LEN = 5000000l;
    //    private final static Long MAX_LENs = 5l;
    //每行数据量
    public final static Integer LINE = 1000;
    public String pathBuffer = "F:\\pathBuffer.bat";
    public String pathRandom = "F:\\pathRandom.bat";

    protected abstract void typeWrite() throws IOException;

    /*
     创建随机ip
     */
    public String randomIP() {
        return String.valueOf(RandomUtils.nextInt(100, 200));
    }
}
