package org.example.testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author jfz
 * @Date 2024/5/28 16:45
 * @PackageName:org.example.testModel
 * @ClassName: CardBase
 */

public interface CardBase {
    public void showCard(List<String> p1, List<String> p2, List<String> p3);
}
