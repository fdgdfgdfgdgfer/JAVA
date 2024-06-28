package org.example.data_handle.access.cread;

import org.example.data_handle.access.TypeWrite;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class BufferWriteOutputImpl extends TypeWrite {
    @Override
    public void typeWrite() throws IOException {
        long start = System.currentTimeMillis();

        File file = new File(pathBuffer);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(file.toPath())),13*1000);
        String value = "";
        for (int i = 1; i < MAX_LEN; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            value = "192.168." + randomIP() + "." + randomIP() + ",";
            for(int j=0;j<1000;j++){
                stringBuilder.append(value);
            }
            bufferedWriter.write(stringBuilder.toString());
            if (i % LINE == 0) {
                bufferedWriter.write("\n");
            }
            i++;
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "s");
    }

    public static void main(String[] args) throws IOException {

    }
}
