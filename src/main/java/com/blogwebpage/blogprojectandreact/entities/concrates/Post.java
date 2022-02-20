package com.blogwebpage.blogprojectandreact.entities.concrates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.xml.catalog.Catalog;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "post_title")
    private int postTitle;
    @Column(name = "post_descrption")
    private int postDescription;
    @Column(name = "post_content")
    private int postContent;
    @OneToOne
    @JoinColumn(name = "cover_image_id")
    private Image coverImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
