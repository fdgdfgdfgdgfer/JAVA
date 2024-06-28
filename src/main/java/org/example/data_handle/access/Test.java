package org.example.data_handle.access;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\aaaa.text");
        file.createNewFile();

        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        FileChannel channel = rw.getChannel();
        int offset = 0;
        for (int i = 0; i < 10; i++) {
            byte[] bytes = "HELLO WORLD".getBytes();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, offset, 2000);
            map.put(bytes);
            offset += bytes.length+1;
            map.clear();
        }

    }

    /**
     * @param :
     * @return void
     * @author Ladidol
     * @description 单线程文件读写. 耗时长, 且主线程堵塞.
     * @date 2022/6/29 21:03
     */
    public void fileReadAndWrite() throws IOException {


    }

    /**
     * @param :
     * @return void
     * @author Ladidol
     * @description 多线程分片对同一个文件进行读和写
     * @date 2022/6/29 21:14
     */

    public void multiThreadReadAndWrite() throws ExecutionException, InterruptedException {

        //开始传输时间
        long start = System.currentTimeMillis();

        File preFile = new File("D:\\迅雷云盘\\[公众号：分派电影]V字仇杀队.V.for.Vendetta.2005.BD1080P.中英双字.mp4");
        String readFile = preFile.getAbsolutePath();//文件路径
        String writeFile = preFile.getParent() + File.separator + "多线程传输-" + start + ".mp4";//新文件名字
        long length = new File(readFile).length(); // 文件一共大小
        int slice = (int) length / 8; // 将文件分成8各部分来传.
        System.out.println("sliceNum = " + slice);
        List<long[]> longs = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            longs.add(new long[]{i * slice});
        }

        //开启线程.
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();
        for (long[] aLong : longs) {
            long l = aLong[0]; // 起始位置
            // 创建线程并运行
            Future<?> randomAccessFile =
//                    ExecutorUtils.createFuture(
                    executorService.submit(
                            () -> {
                                byte[] bytes = new byte[slice];
                                try (
                                        // 在线程内部创RandomAccessFile对象
                                        RandomAccessFile r = new RandomAccessFile(new File(readFile), "r");
                                        RandomAccessFile w = new RandomAccessFile(new File(writeFile), "rw");) {

                                    r.seek(l);
                                    int len = r.read(bytes);
                                    if (len < slice) {
                                        // 调整数组, 避免出现问题.
                                        bytes = getActualBytes(bytes, len);
                                    }

                                    // 写入文件
                                    w.seek(l);
                                    w.write(bytes);
                                    System.out.println("当前线程读写起点: " + l);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //callable的返回值
                                return "call return " + Thread.currentThread().getName();
                            });
            futures.add(randomAccessFile);
        }

        int count = 0;
        for (Future<?> future : futures) {
            count++;
            if (!future.isDone()) {
                System.out.println("资源还没有准备好" + count);
            }
            if (future.isDone()) {
                System.out.println("资源准备好了捏!" + count);
            }
            System.out.println(future.get());
        }

        // 阻塞全部线程执行完毕
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        /*传输测试时间结果(end - start) = 2377*/

    }


    /**
     * @param bytes:
     * @param len:
     * @return byte
     * @author Ladidol
     * @description 截取真实长度的数组.
     * @date 2022/6/30 14:07
     */
    byte[] getActualBytes(byte[] bytes, int len) {
        byte[] b1 = new byte[len];
        System.arraycopy(bytes, 0, b1, 0, len);
        return b1;
    }


}
