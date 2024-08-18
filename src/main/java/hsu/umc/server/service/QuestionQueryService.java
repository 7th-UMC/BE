package hsu.umc.server.service;

import hsu.umc.server.entity.Question;
import org.springframework.stereotype.Service;


public interface QuestionQueryService {
    Question searchQuestion(Long questionId);
}
