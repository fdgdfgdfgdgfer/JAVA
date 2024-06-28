package org.example.data_handle.access.cut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomMap extends Cut {
    @Override
    public void handCut() throws IOException, ExecutionException, InterruptedException {

        File file = new File(randomPath);
        long length = file.length() / 10;
        //线程片
        ArrayList<long[]> longs = new ArrayList<>();

        for (int i = 0; i < cutNumber; i++) {
            //每段起始长度
            longs.add(new long[]{i * length});
        }
        AtomicInteger a = new AtomicInteger(0);
        for (long[] ak : longs) {

            Future<String> task = thread.submit(() -> {
                RandomAccessFile rw = null;
                RandomAccessFile w = null;
                try {
                    rw = new RandomAccessFile(file, "rw");
                    w = new RandomAccessFile(RandomName + Thread.currentThread().getName() + ".text", "rw");
                    FileChannel channel = rw.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, ak[0], length);
                    FileChannel wChannel = w.getChannel();
                    MappedByteBuffer wmap = wChannel.map(FileChannel.MapMode.READ_WRITE, ak[0], length);

                    byte[] bytes = new byte[100000];
//                    map.put(bytes);
//                    map.clear();
                    int i = 0;
                    int size = 0;
                    while (!map.hasRemaining()) {
                        if (size == 100000) {
                            wmap.put(bytes);
                            bytes = new byte[100000];
                            i = 0;
                        }
                        bytes[i] = wmap.get();
                        i++;
                        size++;
                    }
                    wmap.clear();
                    rw.close();
                    w.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return Thread.currentThread().getName();
            });
            a.getAndIncrement();
            task.get();
        }

        System.out.println("end");
    }
}
