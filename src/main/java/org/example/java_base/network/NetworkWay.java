package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author jfz
 * @Date 2024/3/14 16:58
 * @PackageName:org.example.java_base.network
 * @ClassName: NetworkWay
 */
public class NetworkWay {
    public static void main(String[] args) throws UnknownHostException {
        UserDatagramProtocol U2 = new UserDatagramProtocol(10087, "U2");
        Send send = new Send(U2);
        String receive = send.receive();
        System.out.println(receive);
    }
}
