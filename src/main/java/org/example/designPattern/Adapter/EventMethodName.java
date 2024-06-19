package org.example.designPattern.Adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author jfz
 * @Date 2024/2/19 14:37
 * @PackageName:org.example.designPattern.Adapter
 * @ClassName: EventMethodName
 */
public enum EventMethodName {

    ID("id", "setId"), EVENT_ID("eventId", "setEventId"), DESC("desc", "setDesc"), DATE("date", "setDate"), NAME("name", "setName");
    public String name;
    public String method;

    EventMethodName(String name, String method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
