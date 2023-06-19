package com.spring.jpa.chap05_practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageResponseDTO {
    private int startPage;
    private int endPage;
    private int currentPage;
    private boolean prev;
    private boolean next;
    private int totalCount;
}
