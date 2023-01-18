package com.spring.socialmediarestapp.utils;

import com.spring.socialmediarestapp.utils.request.PageDTO;

public class PageUtils {
    public static PageDTO calculatePage(int size, int page, int totalElements){
        PageDTO pageDTO = new PageDTO();
        boolean isFirst = false;
        boolean isLast = false;
        long totalPage = 0;

        if (totalElements % size == 0){
            totalPage = totalElements / size;
        } else{
            totalPage = totalElements / size + 1;
        }

        if (totalPage == page) {
            isLast = true;
        }

        if (page == 1){
            isFirst = true;
        }

        pageDTO.setTotalPages(totalPage);
        pageDTO.setTotalElements(totalElements);
        pageDTO.setLast(isLast);
        pageDTO.setFirst(isFirst);
        pageDTO.setSize(size);
        pageDTO.setPage(page);

        return pageDTO;
    }
}
