package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author jfz
 * @Date 2024/2/19 15:28
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: NbImp
 */
@Service
public class NbImp implements DeviceAdapter{
    @Override
    public void setEvent(String date) {

    }
}
