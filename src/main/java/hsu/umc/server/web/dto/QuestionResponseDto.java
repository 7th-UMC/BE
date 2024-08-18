package hsu.umc.server.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class QuestionResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponseDto {  //질문 생성 응답 DTO
        private Long questionId; //질문 ID
        private LocalDateTime createdAt;//생성 일자

    }
}
