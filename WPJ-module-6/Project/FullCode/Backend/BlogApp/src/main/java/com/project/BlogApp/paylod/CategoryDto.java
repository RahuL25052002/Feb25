package com.project.BlogApp.paylod;


import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class CategoryDto {
    private Integer category_id;
    @NotEmpty
    @Size(min = 3, message = "Size should of minimum 3 characters")
    private String title;
    @NotEmpty(message = "Description should not be empty")
    private String description;
}
