package com.project.BlogApp.paylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Integer id;
    private String content;
    private String userName; // New field to display commenter's name
    private String userId;
}
