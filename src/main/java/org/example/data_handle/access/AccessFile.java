package org.example.data_handle.access;

public class AccessFile {
    private FileBuild fileBuild;

    public AccessFile(FileBuild fileBuild) {
        this.fileBuild = fileBuild;
    }

    public FileMeal getFileHand() {
        fileBuild.setCreateFile();
        fileBuild.setStaticFile();

        return fileBuild.getFileMeal();
    }
}
