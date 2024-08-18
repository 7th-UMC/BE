package hsu.umc.server.service;

import hsu.umc.server.converter.QuestionConverter;
import hsu.umc.server.entity.Question;
import hsu.umc.server.repository.QuestionRepository;
import hsu.umc.server.web.dto.QuestionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionCommandServiceImpl implements QuestionCommandService{

    private final QuestionRepository questionRepository;

    @Override
    @Transactional
    public Question addQuestion(QuestionRequestDto.CreateQuestionRequestDto question) {
        Question newQuestion = QuestionConverter.toQuestion(question);
        return questionRepository.save(newQuestion);
    }
}
