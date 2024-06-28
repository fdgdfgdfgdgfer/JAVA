package org.example.data_handle.access;

import org.example.data_handle.access.cread.FileCreate;
import org.example.data_handle.access.hand.FileStatisticsHand;

public class FileType extends FileBuild{
    @Override
    void setCreateFile() {
        fileMeal.setFileCreate(new FileCreate());
    }

    @Override
    void setStaticFile() {
        fileMeal.setStatisticFile(new FileStatisticsHand());
    }
}
