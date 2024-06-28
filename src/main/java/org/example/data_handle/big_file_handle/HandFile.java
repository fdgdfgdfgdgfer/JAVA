package org.example.data_handle.big_file_handle;


import org.springframework.util.StringUtils;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author jfz
 * @Date 2024/6/17 15:37DNS
 * @PackageName:org.example.data_handle.big_file_handle
 * @ClassName: HandFile
 */
public class HandFile extends HandleModel {
    //统计map
    private final static ConcurrentHashMap<String, AtomicInteger> count = new ConcurrentHashMap<String, AtomicInteger>();
    private final static Integer AGE_MIN = 18;
    private final static Integer AGE_MAX = 70;
    private final static String fileName = "F://test.bat";

    //队列列表
    private final static List<LinkedBlockingQueue<String>> task = new ArrayList<>();

    /**
     * 统计40亿个数据里年纪分布情况
     */
    @Override
    public void hand() throws IOException {
        //初始化map
        //初始化统计map
        System.out.println("初始化统计...");
        for (int i = AGE_MIN; i <= AGE_MAX; i++) {
            count.computeIfAbsent(String.valueOf(i), key -> new AtomicInteger(0));
        }
        //读取数据
        System.out.println("读取数据...");
        BufferedReader orl = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = "";
        int i = 0;
        long start = System.currentTimeMillis();
        while ((line = orl.readLine()) != null) {
            i++;
            System.out.println(i + "行");
            String[] age = line.split(",");
            for (String a : age) {
                count.computeIfAbsent(a, key -> new AtomicInteger()).getAndIncrement();
            }
        }
        System.out.println("统计完毕,共消耗：" + (System.currentTimeMillis() - start) / 1000 + "s");
        AtomicInteger temp = new AtomicInteger(0);
        count.forEach((k, v) -> {
            if (v.get() > temp.get()) {
                AGE = k;
                temp.set(v.get());
            }
        });
        System.out.println(AGE + "岁-" + temp.get() + "次");
    }

    private static String AGE = "";

    /**
     * 多线程，生产者-消费者模型
     */
    public void model() {
        //初始化队列
        initQueue();
        THREAD_POOL_EXECUTOR.execute(() -> {
            //生产者
            try {
                putElement();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //消费者
        THREAD_POOL_EXECUTOR.execute(() -> {
            consume();
        });
        //监听
        THREAD_POOL_EXECUTOR.execute(() -> {
            minor();
        });
    }

    public void minor() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int nums = 0;
            //队列都为空结束
            AtomicInteger queue = new AtomicInteger(0);
            for (LinkedBlockingQueue data : task) {
                if (data.size() == 0) {
                    queue.getAndIncrement();
                }
            }
            System.out.println("监控队列" + "监控状态：" + sendStatus + ",队列大小" + queue.get());
            AtomicInteger temps = new AtomicInteger(0);
            if (!sendStatus && queue.get() == threadNumber) {
                vig = false;
                count.forEach((k, v) -> {
                    if (v.get() > temps.get()) {
                        AGE = k;
                        temps.set(v.get());
                    }
                });
                System.out.println(AGE + "岁-" + temps.get() + "次");
                System.out.println("统计完成");
                break;
            }
        }

    }

    private final static AtomicInteger loop = new AtomicInteger(0);
    private final static Integer threadNumber = 4;

    private static volatile Boolean sendStatus = true;

    public void putElement() throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("F:\\test.bat")));
        String line = "";
        long start = System.currentTimeMillis();
        int op = 0;
        while ((line = bufferedReader.readLine()) != null) {

            //轮询的向队列里加数据
            long index = loop.get() % threadNumber;
            System.out.println(Thread.currentThread().getName() + "投放数据入列" + index);
//            splitLine(line);
                // 如果满了就阻塞
                task.get((int) index).put(line);
                loop.getAndIncrement();

//            if (op % 100 == 0) {
//
//                System.gc();
//
//                log.error("执行出错:", e);
//            }
            if (op % 100 == 0) {
                System.out.println("读取100行,总耗时间: " + (System.currentTimeMillis() - start) / 1000 + " s");
                try {
                    System.gc();
                    Thread.sleep(1000L);

                } catch (InterruptedException e) {
                }
            }
            op++;
        }
        bufferedReader.close();
        sendStatus = false;
        System.out.println("...............................生产完毕...................................");
    }

    public  void splitLine(String lineData) {
//            System.out.println(lineData.length());
        String[] arr = lineData.split("\n");
        for (String str : arr) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            long index = loop.get() % threadNumber;
            try {
                // 如果满了就阻塞
                task.get((int) index).put(str);
            } catch (InterruptedException e) {
            }
            loop.getAndIncrement();

        }
    }

    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2000)
    );
    private static volatile Boolean vig = true;

    public void consume() {

        for (int i = 0; i < threadNumber; i++) {
            final int inx = i;
            THREAD_POOL_EXECUTOR.execute(() -> {
                LinkedBlockingQueue<String> strings = task.get(inx);
                while (vig) {
                    try {
                        String take = strings.take();
                        //消费数据
                        System.out.println(Thread.currentThread().getName() + "消费数据-" + "队列" + inx);
                        consumeElement(take);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }

    public void consumeElement(String element) {
        String[] split = element.split(",");
        for (String a : split) {
            count.computeIfAbsent(a, key -> new AtomicInteger(0)).getAndIncrement();
        }
    }

    public void initQueue() {
        for (int i = 0; i < threadNumber; i++) {
            task.add(new LinkedBlockingQueue<>(366));
        }
    }
}
