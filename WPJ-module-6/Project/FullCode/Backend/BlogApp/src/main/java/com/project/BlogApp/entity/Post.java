package com.project.BlogApp.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Integer postId;

    @Column(name = "post_name", nullable = false)
    private String name;

    private String file;

    @Column(length = 100)
    private String content;

    private Date date;

    @ManyToOne
    @NotNull
    @JsonManagedReference
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne
    @NotNull
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "post", cascade =CascadeType.ALL)
    @JsonIgnore
    List<Comment> comments = new ArrayList<>();
}
