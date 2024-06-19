package org.example.data_handle.big_file_handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/6/17 15:41
 * @PackageName:org.example.data_handle.big_file_handle
 * @ClassName: AdapterHand
 */
public class AdapterHand {

    public static HandleModel getHand(Integer type) {
        if (type == 1) {
            return new CreateFile();
        }
        if (type == 2) {
            return new HandFile();
        }
        return null;
    }

}
