package org.example.java_base.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/14 17:51
 * @PackageName:org.example.java_base.network
 * @ClassName: SendOpt
 */
public interface SendOpt {

    String receive();

    void send(UserDatagramProtocol user, String meg,Integer port);
}
