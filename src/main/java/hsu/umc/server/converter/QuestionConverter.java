package hsu.umc.server.converter;

import hsu.umc.server.entity.Category;
import hsu.umc.server.entity.Question;
import hsu.umc.server.web.dto.AnswerResponseDto;
import hsu.umc.server.web.dto.QuestionRequestDto;
import hsu.umc.server.web.dto.QuestionResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionConverter {
    public static Question toQuestion(QuestionRequestDto.CreateQuestionRequestDto request) {

        return Question.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(Category.fromValue(request.getCategoryId()))
                .isAnswered(false)
                .build();
    }

    public static QuestionResponseDto.CreateResponseDto toCreateResponseDto(Question question) {
        return QuestionResponseDto.CreateResponseDto.builder()
                .questionId(question.getQuestionId())
                .createdAt(question.getCreatedAt())
                .build();
    }

    public static QuestionResponseDto.UpdateResponseDto toUpdateResponseDto(Question question) {
        return QuestionResponseDto.UpdateResponseDto.builder()
                .questionId(question.getQuestionId())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public static QuestionResponseDto.SearchResponseDto toSearchResponseDto(Question question) {
        return QuestionResponseDto.SearchResponseDto.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .isAnswered(question.getIsAnswered())
                .answer(question.getAnswer() != null ?
                        AnswerResponseDto.ReadResponseDto.builder()
                                .answerId(question.getAnswer().getAnswerId())
                                .content(question.getAnswer().getContent())
                                .createdAt(question.getAnswer().getCreatedAt())
                                .updatedAt(question.getAnswer().getUpdatedAt())
                                .build() : null)
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public static QuestionResponseDto.findAllQuestionResponseDto tofindAllQuestionResponseDto(Page<Question> questions) {
        List<QuestionResponseDto.SearchResponseDto> searchResponseDto = questions.getContent().stream()
                .map(QuestionConverter::toSearchResponseDto)
                .toList();

        return QuestionResponseDto.findAllQuestionResponseDto.builder()
                .questionList(searchResponseDto)
                .isFirst(questions.isFirst())
                .isLast(questions.isLast())
                .listSize(questions.getSize())
                .totalPage(questions.getTotalPages())
                .totalElements(questions.getTotalElements())
                .build();
    }

    public static QuestionResponseDto.DeleteResponseDto toDeleteResponseDto(Long questionId) {
        return QuestionResponseDto.DeleteResponseDto.builder()
                .questionId(questionId)
                .message("삭제 성공")
                .build();
    }

    public static List<QuestionResponseDto.findAllResponseDto> tofindAllResponseDto(List<Question> questions) {
        return questions.stream()
                .map(question -> QuestionResponseDto.findAllResponseDto.builder()
                        .isAnswered(question.getIsAnswered())
                        .categoryId(question.getQuestionId())
                        .title(question.getTitle())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
