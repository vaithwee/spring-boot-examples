package xyz.vaith.springbootwithshiro.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Permission {
    private Integer pid;
    private String name;
    private String url;
}
