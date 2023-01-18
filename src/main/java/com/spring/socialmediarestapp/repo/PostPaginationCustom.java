package com.spring.socialmediarestapp.repo;

import com.spring.socialmediarestapp.utils.request.PageDTO;

public interface PostPaginationCustom {
    PageDTO findAllWithCustomProperties(int size, int page, String direction, String properties, String content, String title);
}
