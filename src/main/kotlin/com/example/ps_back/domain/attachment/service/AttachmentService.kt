package com.example.ps_back.domain.attachment.service

import com.example.ps_back.domain.attachment.presentation.dto.response.UploadImageResponse
import com.example.ps_back.global.utils.s3.S3Util
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
public class AttachmentService(
    private val s3Util: S3Util,
) {

    @Transactional
    fun uploadImage(image: MultipartFile): UploadImageResponse {
        return UploadImageResponse(s3Util.uploadImage(image))
    }
}