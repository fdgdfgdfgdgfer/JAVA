package org.example.data_handle.batches;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DateProductImp implements DateProduct {
    //线程池参数
    //最大线程数
    private final static Integer max = 20;
    //核心线程数
    private final static Integer core = 10;
    //线程存活时间
    private final static Integer live = 60;

    private final static LinkedBlockingQueue queue = new LinkedBlockingQueue(2000);

    @Override
    public ThreadPoolExecutor setPool() {
        return new ThreadPoolExecutor(core, max, live, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.AbortPolicy());
    }

    @Override
    public List<List<String>> setDateList(List<String> dateList) {
        return Lists.partition(dateList, 2);
    }
}
