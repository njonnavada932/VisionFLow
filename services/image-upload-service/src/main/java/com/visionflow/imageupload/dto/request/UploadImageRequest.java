package com.visionflow.imageupload.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UploadImageRequest {

    @NotNull(message = "Seller Id is required")
    private UUID sellerId;

}