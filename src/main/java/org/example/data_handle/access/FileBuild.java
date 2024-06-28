package org.example.data_handle.access;

/*
    抽象车间
 */

public abstract class FileBuild {
    public FileMeal fileMeal = new FileMeal();

    abstract void setCreateFile();

    abstract void setStaticFile();

    FileMeal getFileMeal() {
        return fileMeal;
    }
}
