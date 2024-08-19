package hsu.umc.server.converter;

import hsu.umc.server.entity.Answer;
import hsu.umc.server.web.dto.AnswerRequestDto;
import hsu.umc.server.web.dto.AnswerResponseDto;

public class AnswerConverter {
    public static Answer toAnswer(AnswerRequestDto.CreateAnswerRequestDto request){
        return Answer.builder()
                .content(request.getContent())
                .build();
    }
    public static AnswerResponseDto.CreateResponseDto toCreateResponseDto(Answer answer) {
        return AnswerResponseDto.CreateResponseDto.builder()
                .answerId(answer.getAnswerId())
                .createdAt(answer.getCreatedAt())
                .build();
    }
    public static AnswerResponseDto.UpdateResponseDto toUpdateResponseDto(Answer answer){
        return AnswerResponseDto.UpdateResponseDto.builder()
                .answerId(answer.getAnswerId())
                .updatedAt(answer.getUpdatedAt())
                .build();
    }
    public static AnswerResponseDto.DeleteResponseDto toDeleteResponseDto(Long answerId){
        return AnswerResponseDto.DeleteResponseDto.builder()
                .answerId(answerId)
                .message("삭제에 성공했습니다.")
                .build();
    }
}
