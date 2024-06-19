package org.example.designPattern.mediator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/3/6 16:28
 * @PackageName:org.example.designPattern.mediator.model
 * @ClassName: Users
 */


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String address;
    private Date createTime;
    private Date updateTime;

}
