package hsu.umc.server.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class loginDto{
        @NotNull(message = "로그인 Id는 필수 값입니다.")
        private String loginId;
        @NotNull(message = "비밀번호는 필수 값입니다.")
        private String password;
    }


}
