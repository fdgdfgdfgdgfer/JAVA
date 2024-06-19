package org.example.data_handle.big_file_handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @Author jfz
 * @Date 2024/6/17 15:02
 * @PackageName:org.example.data_handle.big_file_handle
 * @ClassName: Handle
 */
public interface Handle {
    void hand() throws IOException;
}
