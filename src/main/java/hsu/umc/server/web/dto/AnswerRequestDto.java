package hsu.umc.server.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AnswerRequestDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateAnswerRequestDto{
        @NotNull(message = "답변 내용은 필수 값입니다.")
        private String content;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestDto{
        @NotNull(message = "답변 내용은 필수 값입니다.")
        private String content;
    }

}
