package hsu.umc.server.service;

import hsu.umc.server.aws.s3.AmazonS3Manager;
import hsu.umc.server.entity.Photo;
import hsu.umc.server.entity.Uuid;
import hsu.umc.server.repository.PhotoRepository;
import hsu.umc.server.repository.UuidRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SchedulerServiceImpl implements SchedulerService{
    private final PhotoRepository photoRepository;
    private final UuidRepository uuidRepository;
    private final AmazonS3Manager s3Manager;
    @Scheduled(cron = "${cloud.aws.cron}")
    @Transactional
    public void deletePhoto() {
        log.info("Scheduled task started for deleting photos");
        List<Photo> photoList = photoRepository.findAll();
        photoList.stream()
                .filter(photo -> Duration.between(photo.getCreatedAt(), LocalDateTime.now()).toMinutes() >= 1)
                .forEach(photo -> {
                    log.info("Processing photo with URL: {}", photo.getPhotoUrl());
                    s3Manager.deleteFile(photo.getPhotoUrl());

                    String uuidUrl = extractUuidFromPhotoUrl(photo.getPhotoUrl());
                    Uuid uuid = uuidRepository.findByUuid(uuidUrl);

                    photoRepository.delete(photo);
                    uuidRepository.delete(uuid);
                });
    }
    private String extractUuidFromPhotoUrl(String photoUrl){
        String[] parts = photoUrl.split("/");
        String uuid = parts[parts.length-1];
        System.out.println(uuid);
        return uuid.replace(".png","");
    }

}
