package org.example.data_handle.access.cut;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class Cut {
    public String bufferName = "F:\\bufferCut";
    public String RandomName = "F:\\randomCut";
    public final static Integer cutNumber = 10;
    public final static String bufferPath = "F:\\pathBuffer.bat";
    public final static String randomPath = "F:\\pathRandom.bat";
    public final static ThreadPoolExecutor thread = new ThreadPoolExecutor(10,20,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(2000),new ThreadPoolExecutor.AbortPolicy());
    abstract void handCut() throws IOException, ExecutionException, InterruptedException;
}
