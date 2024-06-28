package org.example.data_handle.access.hand;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
    处理文件
 */
public class FileStatisticsHand implements FileHand {
    private final static ThreadPoolExecutor threads = new ThreadPoolExecutor(
            10,
            20,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2000)
    );

    @Override
    public void fileHand() throws ExecutionException, InterruptedException {
        //分而治之/hash映射：针对数据太大，内存受限，只能是：把大文件化成(取模映射)小文件，即16字方针：大而化小，各个击破，缩小规模，逐个解决
        //hash_map统计：当大文件转化了小文件，那么我们便可以采用常规的hash_map(ip，value)来进行频率统计。
        //堆/快速排序：统计完了之后，便进行排序(可采取堆排序)，得到次数最多的IP。
        long s = System.currentTimeMillis();
        AtomicInteger a = new AtomicInteger(0);
        HashMap<String, AtomicInteger> stringIntegerHashMap = new HashMap<>();
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> submit = threads.submit(() -> {
                System.out.println("\"F:\\\\bufferCut\" + a.get() + \".text\"");

                File file = new File("F:\\bufferCut" + a.get() + ".text");
                //读取文件
                try {
                    int line = 0;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    char[] chars = new char[1024*30];
                    int length = chars.length;
                    int offset = 0;
                    while ((line = reader.read(chars, offset, length)) != -1) {
                        //统计
                        String string = new String(chars);
                        String[] split = string.split(",");
                        for (String key : split) {
                            stringIntegerHashMap.computeIfAbsent(key, b -> new AtomicInteger(0)).getAndIncrement();
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            futures.add(submit);
        }
        for (Future future : futures) {
            future.get();
        }


        Collection<AtomicInteger> values = stringIntegerHashMap.values();
        ArrayList<AtomicInteger> b = new ArrayList<>(values);
        sort(b, 0, b.size() - 1);
        int max = b.get(b.size() - 1).get();
        Set<Map.Entry<String, AtomicInteger>> entries = stringIntegerHashMap.entrySet();
        String result = "";
        for (Map.Entry<String, AtomicInteger> g : entries) {
            if (g.getValue().get() == max) {
                result = g.getKey();
                System.out.println(result + "一共" + g.getValue() + "次");

            }
        }
        long e = System.currentTimeMillis();
        System.out.println((e - s) / 1000 + "s");
    }

    //快速排序
    public void sort(ArrayList<AtomicInteger> b, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = sortSentinel(b, left, right);
        sort(b, left, i - 1);
        sort(b, i + 1, right);
    }

    public int sortSentinel(ArrayList<AtomicInteger> b, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && b.get(j).get() >= b.get(left).get()) {
                j--;
            }
            while (i < j && b.get(i).get() <= b.get(left).get()) {
                i++;
            }
            swaps(b, i, j);
        }
        swaps(b, i, left);
        return i;
    }

    void swaps(ArrayList<AtomicInteger> b, int left, int right) {
        AtomicInteger atomicInteger = new AtomicInteger(b.get(left).get());
        b.set(left, b.get(right));
        b.set(right, atomicInteger);
    }
}
