package com.visionflow.imageupload.service.storage;

import org.springframework.web.multipart.MultipartFile;

import com.visionflow.imageupload.dto.storage.StorageResult;

public interface ImageStorageService {

    StorageResult store(MultipartFile file);

}