package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author jfz
 * @Date 2024/3/14 17:20
 * @PackageName:org.example.java_base.network
 * @ClassName: UDPTest
 */

public class UDPTest {
    public static void main(String agum[]) {
        UserDatagramProtocol U1 = new UserDatagramProtocol(10086, "U1");
        UserDatagramProtocol U2 = new UserDatagramProtocol(10087, "U2");
        //消息发送接受器
        Send s1 = new Send(U1);
        Send s2 = new Send(U2);
        s1.send(U2,"您好",U2.port);
        String receive = s2.receive();
        while (ObjectUtils.isEmpty(receive)) {

        }
        System.out.println(receive);


    }
}
