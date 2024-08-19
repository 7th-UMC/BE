package hsu.umc.server.service;

import hsu.umc.server.apipayload.code.status.ErrorStatus;
import hsu.umc.server.apipayload.exception.handler.AnswerHandler;
import hsu.umc.server.apipayload.exception.handler.UserHandler;
import hsu.umc.server.entity.Answer;
import hsu.umc.server.entity.User;
import hsu.umc.server.repository.UserRepository;
import hsu.umc.server.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User login(UserRequestDto.loginDto request) {
        User findUser = userRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        if (!findUser.getPassword().equals(request.getPassword())) {
            throw new UserHandler(ErrorStatus.INVALID_CREDENTIALS);
        }
        return findUser;
    }
}
