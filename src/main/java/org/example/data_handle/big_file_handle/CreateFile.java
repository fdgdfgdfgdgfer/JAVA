package org.example.data_handle.big_file_handle;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.Random;

/**
 * @Author jfz
 * @Date 2024/6/17 15:03
 * @PackageName:org.example.data_handle.big_file_handle
 * @ClassName: CreateFile
 */
public class CreateFile extends HandleModel {
    private final static String filePath = "F://test.bat";
    private final static Integer AGE_MIN = 18;
    private final static Integer AGE_MAX = 70;
    private final static Long MAX_LINE = new Double(Integer.MAX_VALUE * 1.7).longValue();
    private final static Integer LINE = 1000000;

    static Integer getaAge(Integer max, Integer min) {
        return new Random().nextInt(max - min + 1) + min;
    }

    @Override
    public void hand() throws IOException {
        //创建文件
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件失败");
            }
        }
        //写数据
        //当前时间
        long begin = System.currentTimeMillis();
        //获得输出流
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        } catch (FileNotFoundException e) {
            System.out.println("获取流失败");
        }
        //以1000000万数据一行
        for (long i = 1; i < MAX_LINE; i++) {
            String age = getaAge(AGE_MAX, AGE_MIN) + ",";
            if (ObjectUtils.isEmpty(bufferedWriter)) {
                return;
            }
            bufferedWriter.write(age);
            if (i % LINE == 0) {
                bufferedWriter.write("\n");
            }
        }
        System.out.println("写入完成!!! 共耗时" + (System.currentTimeMillis() - begin) / 1000 + "s");
        bufferedWriter.close();
    }

    @Override
    public void model() {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String line = "";
            int count = 0;
            long start = System.currentTimeMillis();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("第"+count+"行");
                if (count % 100 == 0) {
                    long end = System.currentTimeMillis();
                    System.out.println("每一百行用时：" + (end - start) / 1000 + "s");
                }
                count++;
            }
            System.out.println("读取完成");
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("读取文件失败");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
