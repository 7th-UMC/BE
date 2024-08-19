package hsu.umc.server.service;

import hsu.umc.server.entity.Question;
import hsu.umc.server.web.dto.QuestionRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionQueryService {
    Question searchQuestion(Long questionId);

    Page<Question> searchQuestionList(Integer page);
    List<Question> searchQuestions();


}
