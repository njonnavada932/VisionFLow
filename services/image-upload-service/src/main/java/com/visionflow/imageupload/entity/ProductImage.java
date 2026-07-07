package com.visionflow.imageupload.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import com.visionflow.imageupload.enums.ImageStatus;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(nullable = false, unique = true)
    private UUID productId;

    @Column(nullable = false, unique = true)
    private UUID requestId;

    @Column(nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String imagePath;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImageStatus status;

}