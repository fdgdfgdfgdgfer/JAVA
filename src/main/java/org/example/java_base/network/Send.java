package org.example.java_base.network;

import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @Author jfz
 * @Date 2024/3/14 17:47
 * @PackageName:org.example.java_base.network
 * @ClassName: Send
 */
public class Send implements SendOpt {
    public UserDatagramProtocol userDatagramProtocol;

    public Send(UserDatagramProtocol userDatagramProtocol) {
        this.userDatagramProtocol = userDatagramProtocol;
    }

    @Override
    public void send(UserDatagramProtocol user, String meg, Integer port) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            //信息包
            DatagramPacket datagramPacket = new DatagramPacket(meg.getBytes(StandardCharsets.UTF_8),
                    meg.length(), InetAddress.getByName("127.0.0.1"), port);
            //发生
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String receive() {
        //本机服务
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(userDatagramProtocol.port);

            //监听
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            datagramSocket.receive(datagramPacket);

            byte[] data = datagramPacket.getData();

            int i = 0;

            System.out.println(new String(data,0,datagramPacket.getLength(), StandardCharsets.UTF_8));

            datagramSocket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
