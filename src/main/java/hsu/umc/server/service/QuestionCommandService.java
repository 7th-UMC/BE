package hsu.umc.server.service;

import hsu.umc.server.entity.Question;
import hsu.umc.server.web.dto.QuestionRequestDto;
import org.springframework.stereotype.Service;


public interface QuestionCommandService {

    Question addQuestion(QuestionRequestDto.CreateQuestionRequestDto question);

    void deleteQuestion(Long questionId);

    Question updateQuestion(Long questionId, QuestionRequestDto.CreateQuestionRequestDto requestDto);
}
