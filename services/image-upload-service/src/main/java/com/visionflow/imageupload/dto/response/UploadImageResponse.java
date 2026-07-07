package com.visionflow.imageupload.dto.response;

import com.visionflow.imageupload.enums.ImageStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UploadImageResponse {

    private UUID productId;

    private UUID requestId;

    private ImageStatus status;

    private String message;

}