package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author jfz
 * @Date 2024/3/14 17:22
 * @PackageName:org.example.java_base.network
 * @ClassName: UserDatagramProtocal
 */

public class UserDatagramProtocol  {
    public Integer port;
    public String name;

    public UserDatagramProtocol(Integer port, String name) {
        this.port = port;
        this.name = name;
    }
}
