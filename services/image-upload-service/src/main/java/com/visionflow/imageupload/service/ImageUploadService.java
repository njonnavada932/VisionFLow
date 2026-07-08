package com.visionflow.imageupload.service;

import com.visionflow.imageupload.dto.request.UploadImageRequest;
import com.visionflow.imageupload.dto.response.UploadImageResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    UploadImageResponse uploadImage(
            MultipartFile image,
            UploadImageRequest request);

}