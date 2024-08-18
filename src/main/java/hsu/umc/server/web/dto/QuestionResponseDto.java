package hsu.umc.server.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hsu.umc.server.entity.Answer;
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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchResponseDto {  //질문 생성 응답 DTO
        private String title;//제목
        private String content;//내용
        @JsonProperty("isAnswered")
        private boolean isAnswered;//답변 여부
        private Answer answer;//답변
        private LocalDateTime createdAt;//생성 일자
        private LocalDateTime updatedAt;//수정 일자
    }
}
