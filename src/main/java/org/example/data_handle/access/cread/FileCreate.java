package org.example.data_handle.access.cread;

import org.example.data_handle.access.hand.FileHand;
import org.example.data_handle.access.cut.CutByBuffer;
import org.example.data_handle.access.cut.RandomMap;

import java.io.*;

/*
    创建文件
 */
public class FileCreate implements FileHand {

    public String type = "";

    //RandomAccessFile + MappedByteBuffer
    @Override
    public void fileHand() throws Exception {
        if (type.equals("BUFFER")) {
            new BufferWriteOutputImpl().typeWrite();
        }
        if (type.equals("RANDOM")) {
            new RandoMapWriteImpl().typeWrite();
        }
        if (type.equals("CUT")) {
            cut();
        }
    }

    //BufferWrite  + output
    public void cut() throws Exception {
        if (type.equals("BUFFER")) {
            new CutByBuffer().handCut();
        }
        if (type.equals("RANDOM")) {
            new RandomMap().handCut();
        }
    }

}



