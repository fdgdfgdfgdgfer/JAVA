package org.example.data_handle.access.cread;

import org.example.data_handle.access.TypeWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RandoMapWriteImpl extends TypeWrite {
    @Override
    public void typeWrite() throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile rw = new RandomAccessFile(new File(pathRandom), "rw");
        FileChannel channel = rw.getChannel();
        long offset = 0;

        for (int i = 1; i < MAX_LEN; i++) {
            String a = "172.168." + randomIP() + "." + randomIP() + ",";
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 1000; j++) {
                stringBuilder.append(a);
            }
            stringBuilder.append(Arrays.toString("\n".getBytes()));
            byte[] bytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, offset, 200*1000);
            map.put(bytes);
            map.clear();
            offset += length + 1;
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "s");
    }
}
