package com.project.BlogApp.paylod;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class PostResponse {
    List<PostDto> content;
    Integer pageNumber;
    Integer pageSize;
    Integer totalPages;
    Long totalElements;
    boolean isLast;
}
