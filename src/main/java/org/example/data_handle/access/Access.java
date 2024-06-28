package org.example.data_handle.access;


import org.example.data_handle.access.cread.FileCreate;

import java.io.IOException;

/**
 * 百度亿级日志数据，检测访问百度次数最多的用户ip
 */
public class Access {

    public static void main(String[] args) throws Exception {
        //构建文件处理器
        FileType fileType = new FileType();
        //获取文件处理器
        FileMeal fileHand = new AccessFile(fileType).getFileHand();
        FileCreate a = (FileCreate) fileHand.getFileCreate();
        //创建40g文件buffer共341s，random共
        a.type = "RANDOM";
        a.cut();
        //统计 192.168.178.111 一共430000次
//        fileHand.getStatisticFile().fileHand();
    }
}
