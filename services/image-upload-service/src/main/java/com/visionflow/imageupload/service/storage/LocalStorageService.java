package com.visionflow.imageupload.service.storage;

import com.visionflow.imageupload.dto.storage.StorageResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class LocalStorageService implements ImageStorageService {

    @Value("${storage.upload-path}")
    private String uploadPath;

    @Override
    public StorageResult store(MultipartFile file) {

        try {

            // 1. Create upload directory if it doesn't exist
            Path uploadDirectory = Paths.get(uploadPath);
            Files.createDirectories(uploadDirectory);

            // 2. Get original filename
            String originalFileName = file.getOriginalFilename();

            // 3. Extract extension
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

            // 4. Generate unique filename
            String generatedFileName = UUID.randomUUID() + extension;

            // 5. Destination path
            Path destination = uploadDirectory.resolve(generatedFileName);

            // 6. Save file
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            // 7. Return result
            return StorageResult.builder()
                    .imageName(originalFileName)
                    .imagePath(destination.toString())
                    .imageUrl(destination.toString())
                    .fileSize(file.getSize())
                    .contentType(file.getContentType())
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("Failed to store image.", e);
        }
    }
}