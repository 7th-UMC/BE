package hsu.umc.server.service;

import hsu.umc.server.apipayload.code.status.ErrorStatus;
import hsu.umc.server.apipayload.exception.handler.QuestionHandler;
import hsu.umc.server.entity.Question;
import hsu.umc.server.repository.QuestionRepository;
import hsu.umc.server.web.dto.QuestionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    public Page<Question> searchQuestionList(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        return questionRepository.findAll(pageRequest);
    }
    @Override
    public List<Question> searchQuestions() {
        return questionRepository.findAll();
    }


}
