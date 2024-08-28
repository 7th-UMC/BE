package hsu.umc.server.service;

import hsu.umc.server.aws.s3.AmazonS3Manager;
import hsu.umc.server.entity.Photo;
import hsu.umc.server.entity.Uuid;
import hsu.umc.server.repository.PhotoRepository;
import hsu.umc.server.repository.UuidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PhotoCommandServiceImpl implements PhotoCommandService{
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;
    private final PhotoRepository photoRepository;
    @Override
    @Transactional
    public Photo createPhoto(MultipartFile photoPicture) {
        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder().uuid(uuid).build());
        String pictureUrl = null;
        try {
            pictureUrl = s3Manager.uploadFile(s3Manager.generatePhotoKeyName(savedUuid), photoPicture);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Photo photo = Photo.builder()
                .photoUrl(pictureUrl)
                .build();

        return photoRepository.save(photo);
    }
}
