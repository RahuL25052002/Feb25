package com.project.BlogApp.paylod;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.entity.Comment;
import com.project.BlogApp.entity.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    @NotEmpty
    @Size(min = 3)
    private String name;
    private String file;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String content;
    private Date date;
    @NotNull
    private Categories categories;
    @NotNull
    private User user;
    List<Comment> comments = new ArrayList<>();
}
