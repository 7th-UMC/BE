package hsu.umc.server.web.controller;


import hsu.umc.server.apipayload.ApiResponse;
import hsu.umc.server.converter.UserConverter;
import hsu.umc.server.entity.User;
import hsu.umc.server.service.UserService;
import hsu.umc.server.web.dto.UserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name="user",description = "회원 관련 API")
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;
    @PostMapping("/login")
    @Operation(summary = "관리자 로그인", description = "주어진 정보를 바탕으로 로그인을 수행합니다.")
    public ApiResponse<Object> login(
            @RequestBody @Valid UserRequestDto.loginDto request
            ){
        User user = userService.login(request);
        return ApiResponse.onSuccess(UserConverter.toLoginResponseDto(user));
    }
}
