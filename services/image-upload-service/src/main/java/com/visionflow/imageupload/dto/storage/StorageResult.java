package com.visionflow.imageupload.dto.storage;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StorageResult {

    private String imageName;

    private String imagePath;

    private String imageUrl;

    private long fileSize;

    private String contentType;

}