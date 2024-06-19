package org.example.data_handle.big_file_handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @Author jfz
 * @Date 2024/6/17 15:06
 * @PackageName:org.example.data_handle.big_file_handle
 * @ClassName: HandleModel
 */
public abstract class HandleModel implements Handle {

    public abstract void model() throws IOException, InterruptedException;
}
