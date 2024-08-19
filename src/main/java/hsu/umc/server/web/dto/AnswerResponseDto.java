package hsu.umc.server.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class AnswerResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResponseDto {
        private Long answerId;
        private LocalDateTime createdAt;

    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadResponseDto {
        private Long answerId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateResponseDto {
        private Long answerId;
        private LocalDateTime updatedAt;

    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteResponseDto {
        private Long answerId;
        private String message;

    }

}
