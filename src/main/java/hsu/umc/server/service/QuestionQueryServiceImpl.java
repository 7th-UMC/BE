package hsu.umc.server.service;

import hsu.umc.server.apipayload.code.status.ErrorStatus;
import hsu.umc.server.apipayload.exception.handler.QuestionHandler;
import hsu.umc.server.entity.Question;
import hsu.umc.server.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionQueryServiceImpl implements QuestionQueryService{

    private final QuestionRepository questionRepository;
    @Override
    public Question searchQuestion(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionHandler(ErrorStatus.QUESTION_NOT_FOUND));

    }
}
