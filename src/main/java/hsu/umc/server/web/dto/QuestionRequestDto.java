package hsu.umc.server.web.dto;

import hsu.umc.server.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class QuestionRequestDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateQuestionRequestDto {  //일기 생성 요청 DTO
        private String title; //질문 제목
        private String content; //질문 내용
        private int categoryId;//카테고리 아이디
    }
}
