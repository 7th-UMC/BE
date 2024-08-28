package hsu.umc.server.service;

import hsu.umc.server.entity.Photo;
import org.springframework.web.multipart.MultipartFile;


public interface PhotoCommandService {
    Photo createPhoto(MultipartFile request);
}
