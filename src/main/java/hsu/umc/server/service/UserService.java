package hsu.umc.server.service;

import hsu.umc.server.entity.User;
import hsu.umc.server.web.dto.UserRequestDto;

public interface UserService {
    User login(UserRequestDto.loginDto request);
}
