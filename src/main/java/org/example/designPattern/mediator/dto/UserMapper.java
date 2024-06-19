package org.example.designPattern.mediator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.mediator.model.User;

/**
 * @Author jfz
 * @Date 2024/3/6 17:20
 * @PackageName:org.example.designPattern.mediator.dto
 * @ClassName: UserMapper
 */
public interface UserMapper {
    User selectOne(Long id);
}
