package io.es.sample.es.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
public class User {
    private String name;
    private String sex;
    private Integer age;
}
