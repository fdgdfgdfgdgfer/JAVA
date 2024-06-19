package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 18:44
 * @PackageName:org.example.java_base.network
 * @ClassName: ReceiveFace
 */

public class ReceiveFace {
    public static void main(String[] args) {
        UserDatagramProtocol U2 = new UserDatagramProtocol(10087, "U2");
        //消息发送接受器
        Send s2 = new Send(U2);
        s2.receive();
    }
}
