package org.example.designPattern.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author jfz
 * @Date 2024/3/3 17:41
 * @PackageName:org.example.designPattern.proxy
 * @ClassName: Techer
 */
@Service
public class Techar implements Action {
    @Override
    public String action() {
        System.out.println("正在上课");
        return "";
    }
}
