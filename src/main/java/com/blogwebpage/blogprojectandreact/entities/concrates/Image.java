package com.blogwebpage.blogprojectandreact.entities.concrates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;
    @Column(name = "iamge_url")
    private String imageUrl;
    @Column(name = "iamge_title")
    private String imageTitle;
    @Column(name = "iamge_sub_info")
    private String imageSubInfo;
    @Column(name = "iamge_size")
    private double imageSize;
    @OneToOne(mappedBy = "image")
    private Profile profile;
    @OneToOne(mappedBy = "coverImage")
    private Post post;


}
