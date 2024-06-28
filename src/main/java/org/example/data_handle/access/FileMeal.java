package org.example.data_handle.access;


import lombok.Data;
import org.example.data_handle.access.hand.FileHand;

/**
 * 文件车间
 */
@Data
public class FileMeal {
    private FileHand fileCreate;
    private FileHand statisticFile;
}
