package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/5/29 9:46
 * @PackageName:org.example.testModel
 * @ClassName: Brigh
 */
public abstract class Brigh {

    public DdzImpl ddz;

    public Brigh(DdzImpl ddz) {
        this.ddz = ddz;
    }
    public abstract void process() throws InterruptedException;
}
