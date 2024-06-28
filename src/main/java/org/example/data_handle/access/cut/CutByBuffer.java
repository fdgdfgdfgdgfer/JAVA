package org.example.data_handle.access.cut;

import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CutByBuffer extends Cut {
    @SneakyThrows
    @Override
    public void handCut() {
        File file = new File(bufferPath);
        String value = "";
        long length = file.length();
        long cutLength = length / 10;

        //线程开始位置
        ArrayList<long[]> longs = new ArrayList<>();
        for (int i = 0; i < cutNumber; i++) {
            longs.add(new long[]{i * cutLength});
        }
        AtomicInteger i = new AtomicInteger(0);
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (long[] ak : longs) {
//            Future<String> submit = thread.submit(() -> {
                BufferedReader bufferedReader = null;
                BufferedWriter bufferedWriter = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bufferName + i.get() + ".text")));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                int cut = 200000000;
                try {
                    BigDecimal divide = new BigDecimal(cutLength).divide(new BigDecimal(cut), 2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal[] decimals = new BigDecimal(cutLength).divideAndRemainder(new BigDecimal(cut));
                    int i1 = divide.intValue();
                    long temp = ak[0];
                    for (int o = 0; o < i1; o++) {
                        if (o == i1 - 1) {
                            char[] chars = new char[decimals[1].intValue()];
                            bufferedReader.skip(temp);
                            int read = bufferedReader.read(chars);
                            bufferedWriter.write(chars);
                            break;
                        }
                        char[] chars = new char[cut];
                        bufferedReader.skip(temp);
                        int read = bufferedReader.read(chars);
                        bufferedWriter.write(chars);
                        temp += cut;
                    }
                    bufferedReader.close();
                    bufferedWriter.close();
//                    return Thread.currentThread().getName();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//            });
            i.getAndIncrement();
//            futures.add(submit);
        }

        for (Future<String> future : futures) {
            String s = future.get();
            System.out.println(s+"完成");
        }

    }
}
