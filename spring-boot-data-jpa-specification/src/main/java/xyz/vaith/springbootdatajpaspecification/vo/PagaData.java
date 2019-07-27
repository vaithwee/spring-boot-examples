package xyz.vaith.springbootdatajpaspecification.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class PagaData {
    private Integer page;
    private Long count;
    private Integer size;
    private Integer number;
    private List<Map<String, Object>> data = new ArrayList<>();
}
