package com.spring.socialmediarestapp.utils.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
    private int page;
    private int size;
    private long totalElements;
    private long totalPages;
    private boolean isLast;
    private boolean isFirst;
    private List<T> data;
}
