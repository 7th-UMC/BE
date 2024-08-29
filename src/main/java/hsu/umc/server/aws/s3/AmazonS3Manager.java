package hsu.umc.server.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import hsu.umc.server.config.AmazonConfig;
import hsu.umc.server.entity.Uuid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmazonS3Manager {
    private final AmazonS3 amazonS3;
    private final AmazonConfig amazonConfig;
    public String uploadFile(String keyName, MultipartFile file)throws IOException {
        System.out.println(keyName);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        amazonS3.putObject(new PutObjectRequest(amazonConfig.getBucket(), keyName, file.getInputStream(), metadata));
        return amazonS3.getUrl(amazonConfig.getBucket(),keyName).toString();
    }
    public String generatePhotoKeyName(Uuid uuid) {
        return amazonConfig.getPhotoPath() + '/' + uuid.getUuid() + ".png";
    }

}
