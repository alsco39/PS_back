package com.example.ps_back.domain.attachment.presentation

import com.example.ps_back.domain.attachment.presentation.dto.response.UploadImageResponse
import com.example.ps_back.domain.attachment.service.AttachmentService
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/images")
@RestController
class AttachmentController(
    private val attachmentService: AttachmentService,
) {

    @PostMapping("/upload")
    public fun uploadImage(@RequestBody image: MultipartFile): UploadImageResponse {
        return attachmentService.uploadImage(image)
    }
}