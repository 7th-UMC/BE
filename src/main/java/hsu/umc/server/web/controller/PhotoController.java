package hsu.umc.server.web.controller;

import hsu.umc.server.apipayload.ApiResponse;
import hsu.umc.server.converter.PhotoConverter;
import hsu.umc.server.entity.Photo;
import hsu.umc.server.service.PhotoCommandService;
import hsu.umc.server.web.dto.PhotoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/photo")
@RequiredArgsConstructor
@Tag(name="photo",description = "네컷사진 관련 API")
public class PhotoController {
    private final PhotoCommandService photoCommandService;
    @PostMapping(value = "/",consumes = "multipart/form-data")
    @Operation(summary = "네컷 사진 저장", description = "제공된 사진을 저장하고 url을 반환합니다.")
    public ApiResponse<PhotoResponseDto.CreatePhotoResultDto> createPhoto(
            @RequestPart("photoPicture") MultipartFile photoPicture) {
        Photo photo = photoCommandService.createPhoto(photoPicture);
        return ApiResponse.onSuccess(PhotoConverter.toCreatePhotoResultDto(photo));
    }

}
