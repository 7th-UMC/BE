package hsu.umc.server.converter;

import hsu.umc.server.entity.Photo;
import hsu.umc.server.web.dto.PhotoResponseDto;

public class PhotoConverter {
    public static PhotoResponseDto.CreatePhotoResultDto toCreatePhotoResultDto(Photo photo){
        return PhotoResponseDto.CreatePhotoResultDto.builder()
                .photoUrl(photo.getPhotoUrl())
                .build();
    }
}
