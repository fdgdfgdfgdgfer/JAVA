package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 18:44
 * @PackageName:org.example.java_base.network

public class SendFace {
public static void main(String[] args) {
UserDatagramProtocol U1 = new UserDatagramProtocol(10086, "U1");
UserDatagramProtocol U2 = new UserDatagramProtocol(10087, "U2");
//消息发送接受器
Send s1 = new Send(U1);
Send s2 = new Send(U2);
s1.send(U2,"hello world",U2.port);
}
 * @ClassName: SendFace
 */
//}
