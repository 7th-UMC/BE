package hsu.umc.server.service;

import hsu.umc.server.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface QuestionQueryService {
    Question searchQuestion(Long questionId);

    Page<Question> searchQuestionList(Integer page);
}
